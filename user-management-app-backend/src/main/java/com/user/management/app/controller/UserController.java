package com.user.management.app.controller;

import com.user.management.app.model.ResultStatus;
import com.user.management.app.model.User;
import com.user.management.app.repository.UserRepository;
import com.user.management.app.service.UserService;
//import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger("UserController");

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/load")
    public ResponseEntity<ResultStatus> fetchUsersAndLoadData() {
        try{
            LOGGER.info("Request received to load user data.");
            ResultStatus resultStatus = userService.fetchUsersAndLoadData();
            return new ResponseEntity<>(resultStatus,HttpStatus.OK);
        } catch (Exception e ){
            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus("Failed");
            resultStatus.setMessage(e.getMessage());
            resultStatus.setStatusCode("500");
            return new ResponseEntity<>(resultStatus,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String query) {
        LOGGER.info("Request received for query {}." , query);
        return userService.searchUsers(query);
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers() {
        LOGGER.info("Request received to get all users");
        return userRepository.findAll();
    }

    @GetMapping("/get-by-id")
    public User getById(@RequestParam Long id){
        LOGGER.info("Request received to get user by ID :: {}" , id);
        User user = userService.getById(id);
        if(user != null){
            LOGGER.info("Response received for ID :: {}" , id);
            return user;
        } else {
            LOGGER.error("No Data for User ID :: {}" , id);
            return null;
//            throw new EntityNotFoundException();
        }
    }

    @GetMapping("/get-by-email")
    public List<User> getById(@RequestParam String email){
        LOGGER.info("Request received to get user by email :: {}" , email);
        return userService.getByEmail(email);
    }
}


