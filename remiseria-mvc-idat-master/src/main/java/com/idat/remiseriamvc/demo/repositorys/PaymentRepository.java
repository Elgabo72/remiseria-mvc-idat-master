package com.idat.remiseriamvc.demo.repositorys;

import com.idat.remiseriamvc.demo.models.Reservation;
import com.idat.remiseriamvc.demo.services.contracts.IPaymentRepository;
import com.idat.remiseriamvc.demo.models.Payment;
import com.idat.remiseriamvc.demo.repositorys.crud.IPaymentCR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PaymentRepository implements IPaymentRepository {
    @Autowired
    private IPaymentCR crud;

    @Override
    public List<Payment> getAll() {
        return (List<Payment>) crud.findAll();
    }

    @Override
    public Optional<Payment> findById(int idPayment) {
        return crud.findById(idPayment);
    }

    @Override
    public Payment save(Payment payment) {
        return crud.save(payment);
    }

    @Override
    public void delete(int idPayment) {
        crud.deleteById(idPayment);
    }

    @Override
    public List<Payment> getPaymentBetweenDate(String dateInit, String dateEnd) {
        return crud.getPaymentBetweenDate(dateInit, dateEnd);
    }
}
