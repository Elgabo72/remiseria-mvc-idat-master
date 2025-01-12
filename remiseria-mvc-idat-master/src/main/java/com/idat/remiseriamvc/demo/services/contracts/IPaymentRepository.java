package com.idat.remiseriamvc.demo.services.contracts;


import com.idat.remiseriamvc.demo.models.Payment;

import java.util.List;
import java.util.Optional;

public interface IPaymentRepository {
    List<Payment> getAll();

    Optional<Payment> findById(int idPayment);

    Payment save(Payment payment);

    void delete(int idPayment);

    List<Payment> getPaymentBetweenDate(String dateInit, String dateEnd);

}
