package com.idat.remiseriamvc.demo.controllers;

import com.idat.remiseriamvc.demo.services.StateReservationService;
import com.idat.remiseriamvc.demo.models.StateReservation;
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
@RequestMapping("/stateReservation")
public class StateReservationController implements ICrudController<StateReservation> {

    @Autowired
    private StateReservationService stateReservationService;


    @GetMapping("/all")
    @ApiOperation("Get all stateReservations")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<StateReservation>> getAll() {
        return new ResponseEntity<>(stateReservationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a stateReservation with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "StateReservation not found")})
    public ResponseEntity<StateReservation> getById(
            @ApiParam(value = "The id of the stateReservation", required = true, example = "5")
            @PathVariable("id") int id) {
        return stateReservationService.findById(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a stateReservation")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<StateReservation> save(@RequestBody StateReservation stateReservation) {
        return new ResponseEntity<>(stateReservationService.save(stateReservation), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a StateReservation")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<StateReservation> update(@RequestBody StateReservation stateReservation1) {

        StateReservation findStateReservation = stateReservationService.findById(stateReservation1.getIdStateReservation()).map(stateReservation -> {
            return stateReservation;
        }).orElse(null);

        findStateReservation.setDescription(stateReservation1.getDescription());

        return new ResponseEntity<>(stateReservationService.save(findStateReservation), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a StateReservation by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the stateReservation", required = true, example = "1")
            @PathVariable("id") int id) {
        return (stateReservationService.delete(id)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
