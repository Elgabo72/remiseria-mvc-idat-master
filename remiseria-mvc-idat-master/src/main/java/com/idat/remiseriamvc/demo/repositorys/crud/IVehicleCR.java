package com.idat.remiseriamvc.demo.repositorys.crud;

import com.idat.remiseriamvc.demo.models.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface IVehicleCR extends CrudRepository<Vehicle, Integer> {

}
