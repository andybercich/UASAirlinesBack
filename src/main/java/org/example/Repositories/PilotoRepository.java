package org.example.Repositories;

import org.example.Entities.Piloto;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PilotoRepository extends RepositorioGenerico<Piloto,Long>{

    //Buscar piloto por tipo de licencia
    List<Piloto> findByTipoLicencia(String tipoLicencia);

    //Buscar pilotos con más de ciertas horas de vuelo
    List<Piloto> findByHorasVueloGreaterThan(int horas);

    //Buscar pilotos por número de licencia
    Optional<Piloto> findByNumLicencia(int numLicencia);

    //Buscar pilotos con inspección reciente (fecha posterior a una fecha específica)
    List<Piloto> findByFechaUltimaInspeccionAfter(LocalDate fecha);

    //Buscar pilotos con pruebas próximas (en un rango de fechas)
    List<Piloto> findByProximaPruebaBetween(LocalDate inicio, LocalDate fin);

    //Contar pilotos con un tipo de licencia específico
    long countByTipoLicencia(String tipoLicencia);

    //Buscar pilotos con un tipo de licencia específico y más de un número determinado de horas de vuelo.
    List<Piloto> findByTipoLicenciaAndHorasVueloGreaterThan(String tipoLicencia, int horas);

}