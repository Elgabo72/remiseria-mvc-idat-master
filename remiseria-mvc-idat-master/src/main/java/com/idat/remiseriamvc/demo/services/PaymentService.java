package com.idat.remiseriamvc.demo.services;

import com.idat.remiseriamvc.demo.models.Payment;
import com.idat.remiseriamvc.demo.repositorys.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public List<Payment> getAll() {
        return repository.getAll();
    }

    public Optional<Payment> findById(int idPayment) {
        return repository.findById(idPayment);
    }

    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    public List<Payment> getPaymentBetweenDate(String dateInit, String dateEnd) {
        return repository.getPaymentBetweenDate(dateInit, dateEnd);
    }
    public boolean delete(int idPayment) {
        return this.findById(idPayment).map(driver -> {
            repository.delete(idPayment);
            return true;
        }).orElse(false);
    }
}
