package com.idat.remiseriamvc.demo.repositorys;

import com.idat.remiseriamvc.demo.services.contracts.IRoleRepository;
import com.idat.remiseriamvc.demo.models.Role;
import com.idat.remiseriamvc.demo.repositorys.crud.IRoleCR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleRepository implements IRoleRepository {
    @Autowired
    private IRoleCR crud;

    @Override
    public List<Role> getAll() {
        return (List<Role>) crud.findAll();
    }

    @Override
    public Optional<Role> findById(int idRole) {
        return crud.findById(idRole);
    }

    @Override
    public Role save(Role role) {
        return crud.save(role);
    }

    @Override
    public void delete(int idRole) {
        crud.deleteById(idRole);
    }
}
