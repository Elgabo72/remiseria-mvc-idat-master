package com.idat.remiseriamvc.demo.services;

import com.idat.remiseriamvc.demo.models.Tariff;
import com.idat.remiseriamvc.demo.repositorys.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TariffService {

    @Autowired
    private TariffRepository repository;

    public List<Tariff> getAll() {
        return repository.getAll();
    }

    public Optional<Tariff> findById(int idTariff) {
        return repository.findById(idTariff);
    }

    public Tariff save(Tariff tariff) {
        return repository.save(tariff);
    }

    public boolean delete(int idTariff) {
        return this.findById(idTariff).map(driver -> {
            driver.setActive(false);
            repository.save(driver);
            return true;
        }).orElse(false);
    }
}
