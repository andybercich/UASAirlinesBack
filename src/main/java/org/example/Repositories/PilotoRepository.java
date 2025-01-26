package org.example.Repositories;

import org.example.Entities.Piloto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
    List<Piloto> findByFechaUltimaInspeccionAfter(Date fecha);

    //Buscar pilotos con pruebas próximas (en un rango de fechas)
    List<Piloto> findByProximaPruebaBetween(Date inicio, Date fin);


    //Contar pilotos con un tipo de licencia específico
    long countByTipoLicencia(String tipoLicencia);

    //Buscar pilotos cuya licencia está próxima a vencer
    @Query("SELECT p FROM Piloto p WHERE p.proximaPrueba <= :fechaLimite")
    List<Piloto> findPilotosConLicenciaPorVencer(@Param("fechaLimite") Date fechaLimite);


}