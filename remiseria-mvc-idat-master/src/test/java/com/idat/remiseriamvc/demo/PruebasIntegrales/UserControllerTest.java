package com.idat.remiseriamvc.demo.PruebasIntegrales;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idat.remiseriamvc.demo.controllers.UserController;
import com.idat.remiseriamvc.demo.models.User;
import com.idat.remiseriamvc.demo.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasSize;

public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void getAllUsers_ReturnsOk() throws Exception {
        User user = new User();
        user.setIdUser(1);
        user.setUsername("testUser");
        when(userService.getAll()).thenReturn(Arrays.asList(user));

        mockMvc.perform(get("/user/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].username").value("testUser"));
    }

    @Test
    public void createUser_ReturnsCreated() throws Exception {
        User user = new User();
        user.setIdUser(1);
        user.setUsername("newUser");

        when(userService.save(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("newUser"));
    }

    @Test
    public void getUserById_ReturnsOk() throws Exception {
        User user = new User();
        user.setIdUser(1);
        user.setUsername("existingUser");

        when(userService.findById(1)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("existingUser"));
    }

    @Test
    public void getUserById_ReturnsNotFound() throws Exception {
        when(userService.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/user/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateUser_ReturnsOk() throws Exception {
        User user = new User();
        user.setIdUser(1);
        user.setUsername("updatedUser");

        when(userService.findById(1)).thenReturn(Optional.of(user));
        when(userService.save(any(User.class))).thenReturn(user);

        mockMvc.perform(put("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("updatedUser"));
    }

    @Test
    public void deleteUser_ReturnsOk() throws Exception {
        when(userService.delete(1)).thenReturn(true);

        mockMvc.perform(delete("/user/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteUser_ReturnsNotFound() throws Exception {
        when(userService.delete(1)).thenReturn(false);

        mockMvc.perform(delete("/user/1"))
                .andExpect(status().isNotFound());
    }
}
