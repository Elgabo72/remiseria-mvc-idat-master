package com.idat.remiseriamvc.demo.controllers;

import com.idat.remiseriamvc.demo.services.PermissionService;
import com.idat.remiseriamvc.demo.models.Permission;
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
@RequestMapping("/permission")
public class PermissionController implements ICrudController<Permission> {

    @Autowired
    private PermissionService permissionService;


    @GetMapping("/all")
    @ApiOperation("Get all permissions")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Permission>> getAll() {
        return new ResponseEntity<>(permissionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a permission with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Permission not found")})
    public ResponseEntity<Permission> getById(
            @ApiParam(value = "The id of the permission", required = true, example = "5")
            @PathVariable("id") int id) {
        return permissionService.findById(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a permission")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Permission> save(@RequestBody Permission permission) {
        return new ResponseEntity<>(permissionService.save(permission), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Permission")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Permission> update(@RequestBody Permission permission1) {

        Permission findPermission = permissionService.findById(permission1.getIdPermission()).map(permission -> {
            return permission;
        }).orElse(null);

        findPermission.setDescription(permission1.getDescription());
        findPermission.setIdRol(permission1.getIdRol());

        return new ResponseEntity<>(permissionService.save(findPermission), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Permission by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the permission", required = true, example = "1")
            @PathVariable("id") int id) {
        return (permissionService.delete(id)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
