package com.idat.remiseriamvc.demo.services.contracts;


import com.idat.remiseriamvc.demo.models.StateReservation;

import java.util.List;
import java.util.Optional;

public interface IStateReservationRepository {
    List<StateReservation> getAll();

    Optional<StateReservation> findById(int idStateReservation);

    StateReservation save(StateReservation stateReservation);

    void delete(int idStateReservation);
}
