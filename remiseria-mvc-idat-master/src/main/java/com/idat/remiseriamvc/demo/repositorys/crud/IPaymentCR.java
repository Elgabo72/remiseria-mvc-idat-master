package com.idat.remiseriamvc.demo.repositorys.crud;

import com.idat.remiseriamvc.demo.models.Payment;
import com.idat.remiseriamvc.demo.models.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPaymentCR extends CrudRepository<Payment, Integer> {
    @Query(value = "SELECT * FROM `payments` r WHERE (r.payment_date BETWEEN ?1 AND ?2)", nativeQuery = true)
    List<Payment> getPaymentBetweenDate(String dateInit, String dateEnd);
}
