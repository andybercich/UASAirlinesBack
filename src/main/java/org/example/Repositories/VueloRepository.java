package org.example.Repositories;

import org.example.Entities.Pasaje;
import org.example.Entities.Vuelo;
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
    List<Vuelo> findByTipoOperacion(TipoOperacion tipoOperacion);

    // Consultas por fechas
    List<Vuelo> findByFechaHoraLlegadaBefore(ZonedDateTime fechaHoraLlegada);
    List<Vuelo> findByFechaHoraSalidaAfter(ZonedDateTime fechaHoraSalida);
    List<Vuelo> findByFechaHoraSalidaBetween(ZonedDateTime startDate, ZonedDateTime endDate);


    //Pasajes
    @Query("SELECT p FROM Pasaje p WHERE p.vuelo.id = :vueloId")
    List<Pasaje> findAllPasajesByVueloId(@Param("vueloId") Long vueloId);

    @Query("SELECT p FROM Pasaje p WHERE p.vuelo.id = :vueloId AND p.vendido = true")
    List<Pasaje> findPasajesVendidosByVueloId(@Param("vueloId") Long vueloId);

    @Query("SELECT p FROM Pasaje p WHERE p.vuelo.id = :vueloId AND p.vendido = false")
    List<Pasaje> findPasajesNoVendidosByVueloId(@Param("vueloId") Long vueloId);

}
