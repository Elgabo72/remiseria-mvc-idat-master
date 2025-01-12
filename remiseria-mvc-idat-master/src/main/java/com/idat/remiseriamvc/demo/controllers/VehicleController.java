package com.idat.remiseriamvc.demo.controllers;

import com.idat.remiseriamvc.demo.services.VehicleService;
import com.idat.remiseriamvc.demo.models.Vehicle;
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
@RequestMapping("/vehicle")
public class VehicleController implements ICrudController<Vehicle> {

    @Autowired
    private VehicleService vehicleService;


    @GetMapping("/all")
    @ApiOperation("Get all vehicles")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Vehicle>> getAll() {
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a vehicle with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Vehicle not found")})
    public ResponseEntity<Vehicle> getById(
            @ApiParam(value = "The id of the vehicle", required = true, example = "5")
            @PathVariable("id") int id) {
        return vehicleService.findById(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a Vehicle")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle) {
        vehicle.setActive(true);
        return new ResponseEntity<>(vehicleService.save(vehicle), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Vehicle")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle) {

        Vehicle findVehicle = vehicleService.findById(vehicle.getIdVehicle()).map(role1 -> {
            return role1;
        }).orElse(null);

        findVehicle.setDescription(vehicle.getDescription());
        findVehicle.setMark(vehicle.getMark());
        findVehicle.setModel(vehicle.getModel());
        findVehicle.setPlaque(vehicle.getPlaque());
        findVehicle.setType(vehicle.getType());
        findVehicle.setActive(vehicle.getActive());
        findVehicle.setIdUser(vehicle.getIdUser());
        return new ResponseEntity<>(vehicleService.save(findVehicle), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Desactive Vehicle by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the vehicle", required = true, example = "1")
            @PathVariable("id") int id) {
        Boolean validate = vehicleService.delete(id);
        if (validate) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}
