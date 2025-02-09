package com.user.management.app.controller;

import com.user.management.app.model.ResultStatus;
import com.user.management.app.model.User;
import com.user.management.app.repository.UserRepository;
import com.user.management.app.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testFetchUsersAndLoadData() throws Exception {
        ResultStatus resultStatus = new ResultStatus("Data Loaded","Success",  "200");
        when(userService.fetchUsersAndLoadData()).thenReturn(resultStatus);

        mockMvc.perform(get("/api/users/load"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("Success"))
                .andExpect(jsonPath("$.message").value("Data Loaded"))
                .andExpect(jsonPath("$.statusCode").value("200"));
    }

    @Test
    void testSearchUsers() throws Exception {
        User user = new User("John", "Doe", "123-45-6789");
        List<User> users = List.of(user);
        when(userService.searchUsers("John")).thenReturn(users);

        mockMvc.perform(get("/api/users/search").param("query", "John"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"));
    }

    @Test
    void testGetAllUsers() throws Exception {
        User user = new User("Jane", "Doe", "987-65-4321");
        when(userRepository.findAll()).thenReturn(List.of(user));

        mockMvc.perform(get("/api/users/get-all-users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Jane"));
    }

    @Test
    void testGetById() throws Exception {
        User user = new User("Alice", "Smith", "111-22-3333");
        when(userService.getById(1L)).thenReturn(user);

        mockMvc.perform(get("/api/users/get-by-id").param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alice"));
    }

    @Test
    void testGetByEmail() throws Exception {
        User user = new User("Bob", "Brown", "444-55-6666");
        user.setEmail("bob@example.com");
        when(userService.getByEmail("bob@example.com")).thenReturn(List.of(user));

        mockMvc.perform(get("/api/users/get-by-email").param("email", "bob@example.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("bob@example.com"));
    }
}
