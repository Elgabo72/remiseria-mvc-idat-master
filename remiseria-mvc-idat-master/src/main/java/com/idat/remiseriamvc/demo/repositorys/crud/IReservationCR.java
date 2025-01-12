package com.idat.remiseriamvc.demo.repositorys.crud;

import com.idat.remiseriamvc.demo.models.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IReservationCR extends CrudRepository<Reservation, Integer> {
    List<Reservation> findByIdStateReservation(Integer idStateReservation);
    List<Reservation> findByIdPassenger(Integer idPassenger);

    @Query(value = "SELECT * FROM `reservations` r WHERE (r.travel_date BETWEEN ?1 AND ?2)", nativeQuery = true)
    List<Reservation> getReservationsBetweenDate(String dateInit, String dateEnd);
}
