package org.example.Services;


import lombok.extern.slf4j.Slf4j;
import org.example.Repositories.RepositorioGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Slf4j
@Service
@Transactional
public abstract class ServiceGeneric<T, ID, Repo extends RepositorioGenerico<T, ID>> {

    @Autowired
    protected Repo repository;

    public T save(T entity) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            log.error("Error al guardar entidad: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public T findById(ID id) throws Exception {
        try {
            Optional<T> entity = repository.findById(id);
            return entity.orElse(null);
        } catch (Exception e) {
            log.error("Error al buscar entidad por ID {}: {}", id, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public List<T> findAll() throws Exception {
        try {
            return repository.findAll();
        } catch (Exception e) {
            log.error("Error al buscar todas las entidades: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }


    @Transactional
    public T update(ID id, T entity) throws Exception {
        try {
            T existingEntity = repository.findById(id)
                    .orElseThrow(() -> new Exception("Entity not found"));

            Map<String, Object> fieldMap = new HashMap<>();

            // Obtener los valores actuales de la entidad existente
            for (Field field : existingEntity.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                fieldMap.put(field.getName(), field.get(existingEntity));
            }

            // Comparar y reemplazar solo los valores que no sean null ni listas vacías
            for (Field field : entity.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object newValue = field.get(entity);

                if (newValue != null) {
                    // Verificar si el valor es una lista y está vacía
                    if (newValue instanceof List && ((List<?>) newValue).isEmpty()) {
                        continue; // No reemplazar listas vacías
                    }
                    fieldMap.put(field.getName(), newValue);
                }
            }

            // Asignar los valores actualizados a la entidad existente
            for (Map.Entry<String, Object> entry : fieldMap.entrySet()) {
                Field field = existingEntity.getClass().getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(existingEntity, entry.getValue());
            }

            return repository.saveAndFlush(existingEntity);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean deleteById(ID id) throws Exception {
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

}


