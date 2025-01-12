package com.idat.remiseriamvc.demo.repositorys;

import com.idat.remiseriamvc.demo.services.contracts.IReservationRepository;
import com.idat.remiseriamvc.demo.models.Reservation;
import com.idat.remiseriamvc.demo.repositorys.crud.IReservationCR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository implements IReservationRepository {
    @Autowired
    private IReservationCR crud;

    @Override
    public List<Reservation> getAll() {
        return (List<Reservation>) crud.findAll();
    }

    @Override
    public List<Reservation> findByIdStateReservation(Integer idStateReservation) {
        return crud.findByIdStateReservation(idStateReservation);
    }

    @Override
    public List<Reservation> findByIdPassenger(Integer idPassenger) {
        return crud.findByIdPassenger(idPassenger);
    }

    @Override
    public List<Reservation> getReservationsBetweenDate(String dateInit, String dateEnd) {
        return crud.getReservationsBetweenDate(dateInit, dateEnd);
    }

    @Override
    public Optional<Reservation> findById(int idReservation) {
        return crud.findById(idReservation);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return crud.save(reservation);
    }

    @Override
    public void delete(int idReservation) {
        crud.deleteById(idReservation);
    }
}
