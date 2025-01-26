package org.example.Repositories;

import org.example.Entities.Piloto;
import org.example.Entities.Tripulacion;
import org.example.Entities.enums.EstadoTripulacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface TripulacionRepository extends RepositorioGenerico<Tripulacion,Long>{

    //Buscar tripulaciones por estado
    List<Tripulacion> findByEstado(EstadoTripulacion estado);

    //Buscar tripulaciones con próximas capacitaciones antes de una fecha específica
    List<Tripulacion> findByProximaCapacitacionBefore(Date fecha);

    //Buscar tripulaciones con un capitán específico
    List<Tripulacion> findByCapitan(Piloto capitan);

    //Buscar tripulaciones que incluyan a un miembro de cabina específico
    @Query("SELECT t FROM Tripulacion t JOIN t.personalCabina pc WHERE pc.id = :personalCabinaId")
    List<Tripulacion> findByPersonalCabina(@Param("personalCabinaId") Long personalCabinaId);

    /*//Buscar tripulaciones sin capitán asignado
    List<Tripulacion> findByCapitanIsNull();*/

    //Buscar tripulaciones que tengan al menos un miembro de cabina con un idioma específico
    @Query("SELECT t FROM Tripulacion t JOIN t.personalCabina pc WHERE :idioma MEMBER OF pc.idiomas")
    List<Tripulacion> findByIdiomaPersonalCabina(@Param("idioma") String idioma);

}