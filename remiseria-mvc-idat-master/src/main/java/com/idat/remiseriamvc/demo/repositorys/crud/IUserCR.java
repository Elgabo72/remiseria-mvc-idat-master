package com.idat.remiseriamvc.demo.repositorys.crud;

import com.idat.remiseriamvc.demo.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IUserCR extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    List<User> findByIdRol(Integer idRol);
    @Query(value = "SELECT * FROM `users` WHERE id_rol != 1 and id_rol!=5", nativeQuery = true)
    List<User> getEmployesAll();

    Optional<User> findByEmail(String email);
}
