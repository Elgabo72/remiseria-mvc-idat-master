package com.idat.remiseriamvc.demo.repositorys.crud;

import com.idat.remiseriamvc.demo.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleCR extends CrudRepository<Role, Integer> {
}
