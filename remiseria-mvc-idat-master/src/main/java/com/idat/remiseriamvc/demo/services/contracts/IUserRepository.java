package com.idat.remiseriamvc.demo.services.contracts;


import com.idat.remiseriamvc.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> getAll();
    List<User> getEmployesAll();
    List<User> findByIdRole(Integer idRol);
    Optional<User> findById(int idUser);

    Optional<User> findByUsername(String username);

    User save(User user);

    void delete(int idUser);
}
