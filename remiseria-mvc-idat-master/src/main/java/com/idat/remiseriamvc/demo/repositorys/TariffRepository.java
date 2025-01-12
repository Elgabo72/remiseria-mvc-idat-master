package com.idat.remiseriamvc.demo.repositorys;

import com.idat.remiseriamvc.demo.services.contracts.ITariffRepository;
import com.idat.remiseriamvc.demo.models.Tariff;
import com.idat.remiseriamvc.demo.repositorys.crud.ITariffCR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TariffRepository implements ITariffRepository {
    @Autowired
    private ITariffCR crud;

    @Override
    public List<Tariff> getAll() {
        return (List<Tariff>) crud.findAll();
    }

    @Override
    public Optional<Tariff> findById(int idTariff) {
        return crud.findById(idTariff);
    }

    @Override
    public Tariff save(Tariff tariff) {
        return crud.save(tariff);
    }

    @Override
    public void delete(int idTariff) {
        crud.deleteById(idTariff);
    }
}
