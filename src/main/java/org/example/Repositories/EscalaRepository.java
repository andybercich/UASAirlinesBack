package org.example.Repositories;

import org.example.Entities.Escala;
import org.example.Entities.Vuelo;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface EscalaRepository extends RepositorioGenerico<Escala, Long>{

    List<Escala> findByVueloId(Long vueloId);

    List<Escala> findByAeropuertoId(Long aeropuerto);

    List<Escala> findByLlegadaAfter(ZonedDateTime fecha);

    List<Escala> findBySalidaBefore(ZonedDateTime fecha);

    List<Escala> findByLlegadaBetween(ZonedDateTime fechaInicio, ZonedDateTime fechaFin);

}
