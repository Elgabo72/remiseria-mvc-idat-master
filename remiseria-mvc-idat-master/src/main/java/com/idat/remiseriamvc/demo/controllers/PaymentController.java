package com.idat.remiseriamvc.demo.controllers;

import com.idat.remiseriamvc.demo.models.Reservation;
import com.idat.remiseriamvc.demo.models.dto.FilterReservationDto;
import com.idat.remiseriamvc.demo.services.PaymentService;
import com.idat.remiseriamvc.demo.models.Payment;
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
@RequestMapping("/payment")
public class PaymentController implements ICrudController<Payment> {

    @Autowired
    private PaymentService paymentService;


    @GetMapping("/all")
    @ApiOperation("Get all payments")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Payment>> getAll() {
        return new ResponseEntity<>(paymentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a payment with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Payment not found")})
    public ResponseEntity<Payment> getById(@ApiParam(value = "The id of the payment", required = true, example = "5") @PathVariable("id") int id) {
        return paymentService.findById(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a payment")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Payment")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Payment> update(@RequestBody Payment payment1) {

        Payment findPayment = paymentService.findById(payment1.getIdPayment()).map(payment -> {
            return payment;
        }).orElse(null);

        findPayment.setPaymentDate(payment1.getPaymentDate());
        findPayment.setAmount(payment1.getAmount());
        findPayment.setIdDriver(payment1.getIdDriver());
        findPayment.setIdEmployee(payment1.getIdEmployee());
        findPayment.setIdVehicle(payment1.getIdVehicle());

        return new ResponseEntity<>(paymentService.save(findPayment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Payment by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(@ApiParam(value = "The id of the payment", required = true, example = "1") @PathVariable("id") int id) {
        return (paymentService.delete(id)) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/filterByTravelDate")
    @ApiOperation("Filter payment by dates")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Payments not found")})
    public ResponseEntity<List<Payment>> filterByTravelDate(@RequestBody FilterReservationDto data) {
        return new ResponseEntity<>(paymentService.getPaymentBetweenDate(data.getDateInit(), data.getDateEnd()), HttpStatus.OK);
    }
}
