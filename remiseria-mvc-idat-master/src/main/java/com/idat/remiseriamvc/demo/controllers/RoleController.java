package com.idat.remiseriamvc.demo.controllers;

import com.idat.remiseriamvc.demo.services.RoleService;
import com.idat.remiseriamvc.demo.models.Role;
import com.idat.remiseriamvc.demo.controllers.interfaces.ICrudController;
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
@RequestMapping("/role")
public class RoleController implements ICrudController<Role> {
    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    @ApiOperation("Get all roles")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Role>> getAll() {
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a role with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Role not found")})
    public ResponseEntity<Role> getById(
            @ApiParam(value = "The id of the role", required = true, example = "5")
            @PathVariable("id") int idCategory) {
        return roleService.findById(idCategory).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a Role")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Role> save(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.save(role), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Role")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Role> update(@RequestBody Role role) {

        Role findRole = roleService.findById(role.getIdRole()).map(role1 -> {
            return role1;
        }).orElse(null);
        findRole.setDescription(role.getDescription());
        return new ResponseEntity<>(roleService.save(findRole), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Role by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the category", required = true, example = "1")
            @PathVariable("id") int idRole) {
        return (roleService.delete(idRole)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
