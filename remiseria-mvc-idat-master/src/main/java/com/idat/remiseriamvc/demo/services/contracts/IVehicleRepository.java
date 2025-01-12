package com.idat.remiseriamvc.demo.services.contracts;


import com.idat.remiseriamvc.demo.models.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> getAll();

    Optional<Vehicle> findById(int idVehicle);

    Vehicle save(Vehicle vehicle);

    void delete(int idVehicle);
}
