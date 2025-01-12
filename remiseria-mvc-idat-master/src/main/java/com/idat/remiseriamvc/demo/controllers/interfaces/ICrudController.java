package com.idat.remiseriamvc.demo.controllers.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICrudController<T> {

    public ResponseEntity<List<T>> getAll();

    public ResponseEntity<T> getById(int id);

    public ResponseEntity<T> save(T entity);

    public ResponseEntity<T> update(T entity);

    public ResponseEntity<?> delete(int id);


}
