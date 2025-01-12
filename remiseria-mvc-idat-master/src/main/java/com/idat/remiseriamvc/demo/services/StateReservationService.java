package com.idat.remiseriamvc.demo.services;

import com.idat.remiseriamvc.demo.models.StateReservation;
import com.idat.remiseriamvc.demo.repositorys.StateReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateReservationService {

    @Autowired
    private StateReservationRepository repository;

    public List<StateReservation> getAll() {
        return repository.getAll();
    }

    public Optional<StateReservation> findById(int idStateReservation) {
        return repository.findById(idStateReservation);
    }

    public StateReservation save(StateReservation stateReservation) {
        return repository.save(stateReservation);
    }

    public boolean delete(int idStateReservation) {
        return this.findById(idStateReservation).map(driver -> {
            repository.delete(idStateReservation);
            return true;
        }).orElse(false);
    }
}
