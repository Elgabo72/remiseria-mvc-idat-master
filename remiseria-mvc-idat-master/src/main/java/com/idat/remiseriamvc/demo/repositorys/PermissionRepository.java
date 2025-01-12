package com.idat.remiseriamvc.demo.repositorys;

import com.idat.remiseriamvc.demo.services.contracts.IPermissionRepository;
import com.idat.remiseriamvc.demo.models.Permission;
import com.idat.remiseriamvc.demo.repositorys.crud.IPermissionCR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PermissionRepository implements IPermissionRepository {
    @Autowired
    private IPermissionCR crud;

    @Override
    public List<Permission> getAll() {
        return (List<Permission>) crud.findAll();
    }

    @Override
    public Optional<Permission> findById(int idPermission) {
        return crud.findById(idPermission);
    }

    @Override
    public Permission save(Permission permission) {
        return crud.save(permission);
    }

    @Override
    public void delete(int idPermission) {
        crud.deleteById(idPermission);
    }
}
