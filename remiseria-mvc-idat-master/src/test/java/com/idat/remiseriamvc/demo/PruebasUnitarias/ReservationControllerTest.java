package com.idat.remiseriamvc.demo.PruebasUnitarias;
import com.idat.remiseriamvc.demo.controllers.ReservationController;
import com.idat.remiseriamvc.demo.models.Reservation;
import com.idat.remiseriamvc.demo.services.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationControllerTest {
    @InjectMocks
    private ReservationController reservationController;

    @Mock
    private ReservationService reservationService;

    private List<Reservation> reservationList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        reservationList = new ArrayList<>();
        // Agregar reservas de ejemplo a reservationList si es necesario
    }

    @Test
    public void testGetAll() {
        List<Reservation> reservationList = new ArrayList<>();
        Reservation reservation = new Reservation();
        reservation.setIdReservation(1);
        reservation.setDescription("Reservation 1");
        reservationList.add(reservation);

        when(reservationService.getAll()).thenReturn(reservationList);
        ResponseEntity<List<Reservation>> response = reservationController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservationList, response.getBody());
    }

    @Test
    public void testGetByIdFound() {
        Reservation reservation = new Reservation();
        reservation.setIdReservation(1);
        reservation.setDescription("Reservation 1");
        when(reservationService.findById(anyInt())).thenReturn(Optional.of(reservation));

        ResponseEntity<Reservation> response = reservationController.getById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservation, response.getBody());
    }

    @Test
    public void testGetByIdNotFound() {
        when(reservationService.findById(anyInt())).thenReturn(Optional.empty());

        ResponseEntity<Reservation> response = reservationController.getById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testGetByIdStateReservationFound() {
        List<Reservation> reservations = new ArrayList<>();
        Reservation reservation = new Reservation();
        reservation.setIdReservation(1);
        reservations.add(reservation);

        when(reservationService.findByIdStateReservation(anyInt())).thenReturn(reservations);

        ResponseEntity<List<Reservation>> response = reservationController.getByIdStateReservation(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservations, response.getBody());
    }

    @Test
    public void testGetByIdPassengerFound() {
        List<Reservation> reservations = new ArrayList<>();
        Reservation reservation = new Reservation();
        reservation.setIdReservation(1);
        reservations.add(reservation);

        when(reservationService.findByIdPassenger(anyInt())).thenReturn(reservations);

        ResponseEntity<List<Reservation>> response = reservationController.getByidPassenger(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservations, response.getBody());
    }


    @Test
    public void testSave() {
        Reservation reservation = new Reservation();
        reservation.setDescription("New Reservation");

        when(reservationService.save(any(Reservation.class))).thenReturn(reservation);

        ResponseEntity<Reservation> response = reservationController.save(reservation);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(reservation, response.getBody());
    }

    @Test
    public void testUpdateFound() {
        Reservation existingReservation = new Reservation();
        existingReservation.setIdReservation(1);
        existingReservation.setDescription("Old Description");

        Reservation updatedReservation = new Reservation();
        updatedReservation.setIdReservation(1);
        updatedReservation.setDescription("New Description");

        when(reservationService.findById(anyInt())).thenReturn(Optional.of(existingReservation));
        when(reservationService.save(any(Reservation.class))).thenReturn(updatedReservation);

        ResponseEntity<Reservation> response = reservationController.update(updatedReservation);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(updatedReservation.getDescription(), response.getBody().getDescription());
    }

    @Test
    public void testDeleteFound() {
        when(reservationService.delete(anyInt())).thenReturn(true);

        ResponseEntity<?> response = reservationController.delete(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDeleteNotFound() {
        when(reservationService.delete(anyInt())).thenReturn(false);

        ResponseEntity<?> response = reservationController.delete(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
