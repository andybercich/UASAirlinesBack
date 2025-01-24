package org.example.Repositories;

import org.example.Entities.Vuelo;
import org.example.Entities.enums.PropositoVuelo;
import org.example.Entities.enums.TipoOperacion;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface VueloRepository extends RepositorioGenerico<Vuelo, Long>{


    List<Vuelo> findByAvionId(Long avionId);

    List<Vuelo> findByOrigenId(Long origenId);

    List<Vuelo> findByDestinoId(Long destinoId);

    List<Vuelo> findByOrigenIdAndDestinoId(Long origenId, Long destinoId);

    @Query("SELECT v FROM Vuelo v JOIN v.escalas e WHERE e.aeropuerto.id = :aeropuertoId")
    List<Vuelo> findByEscalasAeropuertoId(@Param("aeropuertoId") Long aeropuertoId);

    // Consultas por propiedades
    List<Vuelo> findByConEscalaTrue();
    List<Vuelo> findByConEscalaFalse();
    List<Vuelo> findByPropositoVuelo(PropositoVuelo propositoVuelo);
    List<Vuelo> findByTipoOperacion(TipoOperacion tipoOperacion);

    // Consultas por fechas
    List<Vuelo> findByFechaHoraLlegadaBefore(ZonedDateTime fechaHoraLlegada);
    List<Vuelo> findByFechaHoraSalidaAfter(ZonedDateTime fechaHoraSalida);
    List<Vuelo> findByFechaHoraSalidaBetween(ZonedDateTime startDate, ZonedDateTime endDate);

}
