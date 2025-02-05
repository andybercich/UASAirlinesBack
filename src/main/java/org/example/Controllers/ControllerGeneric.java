package org.example.Controllers;


import jakarta.validation.Valid;
import org.example.Repositories.RepositorioGenerico;
import org.example.Services.ServiceGeneric;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping("/uasAirlines")
public abstract class ControllerGeneric<T, ID, Repo extends RepositorioGenerico<T,ID>,
        Service extends ServiceGeneric<T, ID, Repo >> {

    protected final Service service;

    public ControllerGeneric(Service service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable ID id) {
        try {
            T entity = service.findById(id);
            if (entity == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<T> create(@Valid @RequestBody T entity) {
        try {
            T createdEntity = service.save(entity);
            return ResponseEntity.ok(createdEntity);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        try {
            T updatedEntity = service.update(id, entity);
            if (updatedEntity == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedEntity);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        try {
            boolean deleted = service.deleteById(id);
            if (!deleted) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

