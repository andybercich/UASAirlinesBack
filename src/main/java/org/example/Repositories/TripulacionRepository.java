package org.example.Repositories;

import org.example.Entities.Piloto;
import org.example.Entities.Tripulacion;
import org.example.Entities.enums.EstadoTripulacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;

@Repository
public interface TripulacionRepository extends RepositorioGenerico<Tripulacion,Long>{

    //Buscar tripulaciones por estado
    List<Tripulacion> findByEstado(EstadoTripulacion estado);

    //Buscar tripulaciones con próximas capacitaciones antes de una fecha específica
    List<Tripulacion> findByProximaCapacitacionBefore(LocalDate fecha);

    //Buscar tripulaciones con un capitán específico
    List<Tripulacion> findByCapitan(Piloto capitan);

    //Buscar tripulaciones con un capitán específico y en un estado determinado.
     List<Tripulacion> findByCapitanAndEstado(Piloto capitan, EstadoTripulacion estado);

    //Buscar tripulaciones con un copiloto específico.
    List<Tripulacion> findByCopiloto(Piloto copiloto);

}