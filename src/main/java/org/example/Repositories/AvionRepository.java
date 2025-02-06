package org.example.Repositories;

import org.example.Entities.Aeropuerto;
import org.example.Entities.Avion;
import org.example.Entities.ConfiguracionCabina;
import org.example.Entities.EstadoMantenimiento;
import org.example.Entities.enums.EstadoAvion;
import org.example.Repositories.RepositorioGenerico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AvionRepository extends RepositorioGenerico<Avion, Long> {



    // Buscar por matrícula (única)
    Optional<Avion> findByMatricula(String matricula);

    // Buscar por modelo
    List<Avion> findByModelo(String modelo);

    // Buscar por fabricante
    List<Avion> findByFabricante(String fabricante);

    // Buscar aviones por estado
    List<Avion> findByEstado(EstadoAvion estado);

    // Buscar aviones que tengan una cantidad de asientos mayor a X
    List<Avion> findByCantidadAsientosGreaterThan(int cantidad);

    // Buscar aviones con un rango de vuelo mayor a X km
    List<Avion> findByRangoVueloKmGreaterThan(double rangoVuelo);

    // Buscar aviones en un aeropuerto específico
    List<Avion> findByUbicacionActual(Aeropuerto aeropuerto);

    // Buscar aviones que necesiten mantenimiento (según el estado de mantenimiento)
    List<Avion> findByEstadoMantenimiento(EstadoMantenimiento estadoMantenimiento);

    // Buscar aviones creados después de una fecha específica
    List<Avion> findByFechaCreacionAfter(LocalDate fecha);

    // Contar la cantidad de aviones en un aeropuerto específico
    long countByUbicacionActual(Aeropuerto aeropuerto);
}
