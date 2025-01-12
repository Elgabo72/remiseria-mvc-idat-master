package com.idat.remiseriamvc.demo.controllers;

import com.idat.remiseriamvc.demo.services.UserService;
import com.idat.remiseriamvc.demo.models.User;
import com.idat.remiseriamvc.demo.shared.Enviroments;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @CrossOrigin(origins="*")
@RestController
@RequestMapping("/public")
public class PublicController {


    @Autowired
    private Enviroments env;

    @Autowired
    private UserService clientService;

    @GetMapping("/users/all")
    @ApiOperation("Get all Clients")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<List<User>> getClients() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }


}
