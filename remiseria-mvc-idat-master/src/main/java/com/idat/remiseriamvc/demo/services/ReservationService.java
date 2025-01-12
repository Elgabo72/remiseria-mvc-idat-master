package com.idat.remiseriamvc.demo.services;

import com.idat.remiseriamvc.demo.models.Reservation;
import com.idat.remiseriamvc.demo.repositorys.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAll() {
        return repository.getAll();
    }

    public Optional<Reservation> findById(int idReservation) {
        return repository.findById(idReservation);
    }

    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    public List<Reservation> findByIdStateReservation(Integer idStateReservation) {
        return repository.findByIdStateReservation(idStateReservation);
    }

    public List<Reservation> findByIdPassenger(Integer idPassenger) {
        return repository.findByIdPassenger(idPassenger);
    }

    public List<Reservation> getReservationsBetweenDate(String dateInit, String dateEnd) {
        return repository.getReservationsBetweenDate(dateInit, dateEnd);
    }

    public boolean delete(int idReservation) {
        return this.findById(idReservation).map(driver -> {
            repository.delete(idReservation);
            return true;
        }).orElse(false);
    }
}
