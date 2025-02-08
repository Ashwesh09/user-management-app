package com.user.management.app.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.management.app.model.ResultStatus;
import com.user.management.app.model.User;
import com.user.management.app.model.UserResponse;
import com.user.management.app.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.search.engine.search.common.BooleanOperator;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserService {

    private final WebClient webClient;

    private static final Logger LOGGER = LoggerFactory.getLogger("UserService");


    @Value("${user.management.url.mapping}")
    private String mapping;


    private final UserRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public UserService(WebClient webClient,UserRepository repository) {
        this.webClient = webClient;
        this.repository = repository;
    }

    public List<User> searchUsers(String query) {
        SearchSession searchSession = Search.session(entityManager);
        SearchResult<User> result = searchSession.search(User.class)
                .where(f -> f.simpleQueryString()
                        .fields("firstName", "lastName", "ssn")
                        .matching(query)
                        .defaultOperator(BooleanOperator.AND)
                )
                .fetch(20);
        LOGGER.info("Response received from DB for query :: {}.", query);
        return result.hits();
    }

    public ResultStatus fetchUsersAndLoadData() {
        try {
            UserResponse response = webClient.get()
                    .uri("/users")
                    .retrieve()
                    .bodyToMono(UserResponse.class)
                    .block();

            LOGGER.info("User data successfully fetched from URL :: https://dummyjson.com{}",mapping);
            if(response != null)
                repository.saveAll(response.getUsers());
            LOGGER.info("Database updated with user data.");
            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatusCode("200");
            resultStatus.setMessage("Users fetched and stored in H2!");
            resultStatus.setStatus("Success");
            return resultStatus;
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("Error while fetching users from DB :: {}", e.getMessage());
            return null;
        }
    }

    public User getById(Long id){
        return repository.getReferenceById(id);
    }

    public List<User> getByEmail(String email){
        return repository.findByEmail(email);
    }

}