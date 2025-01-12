package com.idat.remiseriamvc.demo.services;

import com.idat.remiseriamvc.demo.models.User;
import com.idat.remiseriamvc.demo.shared.EncryptPassword;
import com.idat.remiseriamvc.demo.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.getAll();
    }

    public List<User> getEmployesAll() {
        return repository.getEmployesAll();
    }

    public List<User> findByIdRole(Integer idRole) {
        return repository.findByIdRole(idRole);
    }

    public Optional<User> findById(int idUser) {
        return repository.findById(idUser);
    }

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User save(User user) {
        // Verifica si la contraseña no está encriptada (es decir, no comienza con un prefijo de un hash como "$2a$10$" para BCrypt)
        if (user.getPassword() != null && !user.getPassword().equals("") && !user.getPassword().startsWith("$2a$")) {
            // Si la contraseña no está encriptada, encriptarla
            user.setPassword(EncryptPassword.encrypt(user.getPassword()));
        }
        // Guarda el usuario en el repositorio
        return repository.save(user);
    }

    public User updatePassword(int userId, String newPassword) {
        // Buscar el usuario por ID
        User findUser = repository.findById(userId).orElse(null);

        if (findUser != null && newPassword != null && !newPassword.isEmpty()) {
            // Encriptar la nueva contraseña
            findUser.setPassword(EncryptPassword.encrypt(newPassword));

            // Guardar el usuario con la nueva contraseña encriptada
            return repository.save(findUser);
        }

        // Retornar null o lanzar una excepción si no se encuentra el usuario o la contraseña no es válida
        return null;
    }


    public boolean delete(int idUser) {
        User findUser = this.findById(idUser).map(driver -> {

            return driver;
        }).orElse(null);

        if (findUser != null) {
            findUser.setActive(false);
            repository.save(findUser);
            return true;
        }
        return false;
    }
}
