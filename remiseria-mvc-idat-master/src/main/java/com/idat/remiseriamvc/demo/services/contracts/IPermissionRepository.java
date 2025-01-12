package com.idat.remiseriamvc.demo.services.contracts;


import com.idat.remiseriamvc.demo.models.Permission;

import java.util.List;
import java.util.Optional;

public interface IPermissionRepository {
    List<Permission> getAll();

    Optional<Permission> findById(int idPermission);

    Permission save(Permission permission);

    void delete(int idPermission);
}
