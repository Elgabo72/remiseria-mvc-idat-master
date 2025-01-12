package com.idat.remiseriamvc.demo.controllers;

import com.idat.remiseriamvc.demo.services.UserService;
import com.idat.remiseriamvc.demo.models.User;
import com.idat.remiseriamvc.demo.controllers.interfaces.ICrudController;
import com.idat.remiseriamvc.demo.shared.EncryptPassword;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements ICrudController<User> {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ApiOperation("Get all users")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/allEmployes")
    @ApiOperation("Get all employes")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<User>> getAllEmployes() {
        return new ResponseEntity<>(userService.getEmployesAll(), HttpStatus.OK);
    }


    @GetMapping("/findByRole/{id}")
    @ApiOperation("Search a user filter id role")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "User not found")})
    public ResponseEntity<List<User>> getByIdRole(
            @ApiParam(value = "The id role", required = true, example = "5")
            @PathVariable("id") int idRole) {
        return new ResponseEntity<>(userService.findByIdRole(idRole), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a user with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "User not found")})
    public ResponseEntity<User> getById(
            @ApiParam(value = "The id of the user", required = true, example = "5")
            @PathVariable("id") int idCategory) {
        return userService.findById(idCategory).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a User")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<User> save(@RequestBody User user) {
        user.setActive(true);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a User")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<User> update(@RequestBody User user) {

        User findUser = userService.findById(user.getIdUser()).map(user1 -> {
            return user1;
        }).orElse(null);
        //   findUser.setPassword(user.getPassword());
        findUser.setAddress(user.getAddress());
        findUser.setActive(user.getActive());
        findUser.setEmail(user.getEmail());
        findUser.setFirstName(user.getFirstName());
        findUser.setLastName(user.getLastName());
        findUser.setPhone(user.getPhone());
        findUser.setIdRol(user.getIdRol());
        return new ResponseEntity<>(userService.save(findUser), HttpStatus.CREATED);
    }

    @PutMapping("/updatePassword/{userId}")
    @ApiOperation("Update user password")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<User> updatePassword(
            @ApiParam(value = "The id of the user", required = true, example = "1")
            @PathVariable("userId") int userId,
            @ApiParam(value = "New password", required = true, example = "newPassword123")
            @RequestBody String newPassword) {

        // Llamar al servicio para actualizar la contraseña
        User updatedUser = userService.updatePassword(userId, newPassword);
        System.out.println("Contraseña antes de encriptar: " + newPassword);
        System.out.println("Contraseña encriptada: " + EncryptPassword.encrypt(newPassword));
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatePassenger")
    @ApiOperation("Update a User")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<User> updatePassenger(@RequestBody User user) {

        User findUser = userService.findById(user.getIdUser()).map(user1 -> {
            return user1;
        }).orElse(null);
        findUser.setPassword(user.getPassword());
        findUser.setAddress(user.getAddress());
        findUser.setActive(user.getActive());
        findUser.setFirstName(user.getFirstName());
        findUser.setLastName(user.getLastName());
        findUser.setActive(user.getActive());
        return new ResponseEntity<>(userService.save(findUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a User by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the user", required = true, example = "1")
            @PathVariable("id") int idUser) {
        return (userService.delete(idUser)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
