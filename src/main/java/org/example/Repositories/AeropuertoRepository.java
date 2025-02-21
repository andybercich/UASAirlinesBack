package org.example.Repositories;

import org.example.Entities.Aeropuerto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AeropuertoRepository extends RepositorioGenerico<Aeropuerto, Long >{

    @Query("SELECT DISTINCT e.aeropuerto FROM Escala e WHERE e.vuelo.destino.ciudad.nombre = :ciudadNombre")
    List<Aeropuerto> findAeropuertosConEscalasEnDestino(@Param("ciudadNombre") String ciudadNombre);

    @Query("SELECT a FROM Aeropuerto a JOIN a.llegadas v WHERE v.origen.ciudad.nombre = :ciudadNombre")
    List<Aeropuerto> findByOrigenCiudad(@Param("ciudadNombre") String ciudadNombre);

    @Query("SELECT a FROM Aeropuerto a JOIN a.salidas v WHERE v.destino.ciudad.nombre = :ciudadNombre")
    List<Aeropuerto> findByDestinoCiudad(@Param("ciudadNombre") String ciudadNombre);

    List<Aeropuerto> findByCiudadNombreIgnoreCase(String ciudadNombre);

    List<Aeropuerto> findByNombreIgnoreCase(String nombre);
}
