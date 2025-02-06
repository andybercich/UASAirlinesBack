package org.example.Services;

import org.example.Entities.Aeropuerto;
import org.example.Entities.Avion;
import org.example.Entities.ConfiguracionCabina;
import org.example.Entities.EstadoMantenimiento;
import org.example.Entities.enums.EstadoAvion;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.Repositories.AvionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class AvionService extends ServiceGeneric<Avion, Long, AvionRepository> {


    @Autowired
    public AvionService(AvionRepository avionRepository) {
        this.repository = avionRepository;
    }

    // Buscar un avión por su matrícula (única)
    public Optional<Avion> buscarPorMatricula(String matricula) throws Exception {
        try {
            return repository.findByMatricula(matricula);  // Busca un avión por matrícula en la base de datos
        } catch (Exception e) {
            throw new Exception(e.getMessage());  // Lanza una excepción en caso de error
        }
    }

    // Buscar aviones por modelo
    public List<Avion> buscarPorModelo(String modelo) throws Exception {
        try {
            return repository.findByModelo(modelo);  // Busca todos los aviones con el modelo especificado
        } catch (Exception e) {
            throw new Exception(e.getMessage());  // Lanza una excepción en caso de error
        }
    }

    // Buscar aviones por fabricante
    public List<Avion> buscarPorFabricante(String fabricante) throws Exception {
        try {
            return repository.findByFabricante(fabricante);  // Busca todos los aviones fabricados por el fabricante especificado
        } catch (Exception e) {
            throw new Exception(e.getMessage());  // Lanza una excepción en caso de error
        }
    }

    // Buscar aviones por estado (activo, inactivo, etc.)
    public List<Avion> buscarPorEstado(EstadoAvion estado) throws Exception {
        try {
            return repository.findByEstado(estado);  // Busca todos los aviones con el estado proporcionado
        } catch (Exception e) {
            throw new Exception(e.getMessage());  // Lanza una excepción en caso de error
        }
    }

    // Buscar aviones que tengan una cantidad de asientos mayor al valor proporcionado
    public List<Avion> buscarPorCantidadAsientosMayorA(int cantidad) throws Exception {
        try {
            return repository.findByCantidadAsientosGreaterThan(cantidad);  // Busca aviones con más asientos que el número proporcionado
        } catch (Exception e) {
            throw new Exception(e.getMessage());  // Lanza una excepción en caso de error
        }
    }

    // Buscar aviones con un rango de vuelo mayor al valor proporcionado
    public List<Avion> buscarPorRangoVueloMayorA(double rangoVuelo) throws Exception {
        try {
            return repository.findByRangoVueloKmGreaterThan(rangoVuelo);  // Busca aviones con un rango de vuelo mayor al valor dado
        } catch (Exception e) {
            throw new Exception(e.getMessage());  // Lanza una excepción en caso de error
        }
    }


    // Buscar aviones según su ubicación actual (aeropuerto)
    public List<Avion> buscarPorUbicacionActual(Aeropuerto aeropuerto) throws Exception {
        try {
            return repository.findByUbicacionActual(aeropuerto);  // Busca todos los aviones en el aeropuerto proporcionado
        } catch (Exception e) {
            throw new Exception(e.getMessage());  // Lanza una excepción en caso de error
        }
    }


    // Buscar aviones por estado de mantenimiento
    public List<Avion> buscarPorEstadoMantenimiento(EstadoMantenimiento estadoMantenimiento) throws Exception {
        try {
            return repository.findByEstadoMantenimiento(estadoMantenimiento);  // Busca aviones que están en el estado de mantenimiento proporcionado
        } catch (Exception e) {
            throw new Exception(e.getMessage());  // Lanza una excepción en caso de error
        }
    }



    // Contar la cantidad de aviones ubicados en un aeropuerto específico
    public long contarPorUbicacionActual(Aeropuerto aeropuerto) throws Exception {
        try {
            return repository.countByUbicacionActual(aeropuerto);  // Cuenta cuántos aviones están en el aeropuerto dado
        } catch (Exception e) {
            throw new Exception(e.getMessage());  // Lanza una excepción en caso de error
        }
    }




}