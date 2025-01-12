package com.idat.remiseriamvc.demo.controllers;

import com.idat.remiseriamvc.demo.services.TariffService;
import com.idat.remiseriamvc.demo.models.Tariff;
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
@RequestMapping("/tariff")
public class TariffController implements ICrudController<Tariff> {
    @Autowired
    private TariffService tariffService;

    @GetMapping("/all")
    @ApiOperation("Get all tariffs")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Tariff>> getAll() {
        return new ResponseEntity<>(tariffService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a tariff with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Tariff not found")})
    public ResponseEntity<Tariff> getById(
            @ApiParam(value = "The id of the tariff", required = true, example = "5")
            @PathVariable("id") int idCategory) {
        return tariffService.findById(idCategory).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a Tariff")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Tariff> save(@RequestBody Tariff tariff) {
        return new ResponseEntity<>(tariffService.save(tariff), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Tariff")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Tariff> update(@RequestBody Tariff tariff) {

        Tariff findTariff = tariffService.findById(tariff.getIdTariff()).map(tariff1 -> {
            return tariff1;
        }).orElse(null);

        findTariff.setDescription(tariff.getDescription());
        findTariff.setAmount(tariff.getAmount());
        findTariff.setDestination(tariff.getDestination());
        findTariff.setOrigin(tariff.getOrigin());
        findTariff.setActive(tariff.getActive());

        return new ResponseEntity<>(tariffService.save(findTariff), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Tariff by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the tariff", required = true, example = "1")
            @PathVariable("id") int idTariff) {
        return (tariffService.delete(idTariff)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
