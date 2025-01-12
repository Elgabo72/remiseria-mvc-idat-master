package com.idat.remiseriamvc.demo.PruebasUnitarias;
import com.idat.remiseriamvc.demo.controllers.UserController;
import com.idat.remiseriamvc.demo.models.User;
import com.idat.remiseriamvc.demo.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private List<User> userList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userList = new ArrayList<>();
        // Aquí puedes agregar usuarios de ejemplo si es necesario
    }

    @Test
    public void testGetAll() {
        User user = new User();
        user.setIdUser(1);
        user.setFirstName("John");
        userList.add(user);

        when(userService.getAll()).thenReturn(userList);
        ResponseEntity<List<User>> response = userController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userList, response.getBody());
    }

    @Test
    public void testGetAllEmployes() {
        User user = new User();
        user.setIdUser(1);
        user.setFirstName("Jane");
        userList.add(user);

        when(userService.getEmployesAll()).thenReturn(userList);
        ResponseEntity<List<User>> response = userController.getAllEmployes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userList, response.getBody());
    }

    @Test
    public void testGetByIdFound() {
        User user = new User();
        user.setIdUser(1);
        user.setFirstName("John");
        when(userService.findById(anyInt())).thenReturn(Optional.of(user));

        ResponseEntity<User> response = userController.getById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testGetByIdNotFound() {
        when(userService.findById(anyInt())).thenReturn(Optional.empty());

        ResponseEntity<User> response = userController.getById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setFirstName("New User");

        when(userService.save(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.save(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testUpdateFound() {
        User existingUser = new User();
        existingUser.setIdUser(1);
        existingUser.setFirstName("Old Name");

        User updatedUser = new User();
        updatedUser.setIdUser(1);
        updatedUser.setFirstName("New Name");

        when(userService.findById(anyInt())).thenReturn(Optional.of(existingUser));
        when(userService.save(any(User.class))).thenReturn(updatedUser);

        ResponseEntity<User> response = userController.update(updatedUser);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(updatedUser.getFirstName(), response.getBody().getFirstName());
    }

    @Test
    public void testDeleteFound() {
        when(userService.delete(anyInt())).thenReturn(true);

        ResponseEntity<?> response = userController.delete(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDeleteNotFound() {
        when(userService.delete(anyInt())).thenReturn(false);

        ResponseEntity<?> response = userController.delete(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
