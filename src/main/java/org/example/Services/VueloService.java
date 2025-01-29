package org.example.Services;

import org.example.DTO.VueloTagDTO;
import org.example.Entities.Vuelo;
import org.example.Entities.enums.PropositoVuelo;
import org.example.Entities.enums.TipoOperacion;
import org.example.Repositories.PasajeRepository;
import org.example.Repositories.VueloRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VueloService extends ServiceGeneric<Vuelo, Long, VueloRepository> {

    public VueloService(VueloRepository vueloRepository) {
        this.repository = vueloRepository;
    }

    public List<VueloTagDTO> findByAvionId(Long avionId) {
        List<Vuelo> vuelos = repository.findByAvionId(avionId);
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> findByOrigenId(Long origenId) {
        List<Vuelo> vuelos = repository.findByOrigenId(origenId);
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> findByDestinoId(Long destinoId) {
        List<Vuelo> vuelos = repository.findByDestinoId(destinoId);
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> findByOrigenIdAndDestinoId(Long origenId, Long destinoId) {
        List<Vuelo> vuelos = repository.findByOrigenIdAndDestinoId(origenId, destinoId);
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> findByEscalasAeropuertoId(Long aeropuertoId) {
        List<Vuelo> vuelos = repository.findByEscalasAeropuertoId(aeropuertoId);
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> findByConEscalaTrue() {
        List<Vuelo> vuelos = repository.findByConEscalaTrue();
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> findByConEscalaFalse() {
        List<Vuelo> vuelos = repository.findByConEscalaFalse();
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> findByPropositoVuelo(PropositoVuelo propositoVuelo) {
        List<Vuelo> vuelos = repository.findByPropositoVuelo(propositoVuelo);
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> findByTipoOperacion(TipoOperacion tipoOperacion) {
        List<Vuelo> vuelos = repository.findByTipoOperacion(tipoOperacion);
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> findByFechaHoraLlegadaBefore(ZonedDateTime fechaHoraLlegada) {
        List<Vuelo> vuelos = repository.findByFechaHoraLlegadaBefore(fechaHoraLlegada);
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> findByFechaHoraSalidaAfter(ZonedDateTime fechaHoraSalida) {
        List<Vuelo> vuelos = repository.findByFechaHoraSalidaAfter(fechaHoraSalida);
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> findByFechaHoraSalidaBetween(ZonedDateTime startDate, ZonedDateTime endDate) {
        List<Vuelo> vuelos = repository.findByFechaHoraSalidaBetween(startDate, endDate);
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    public List<VueloTagDTO> getAllVueloDTOTagByOrigneAndDestino(Long idOrigen, Long idDestino) throws Exception {
        List<Vuelo> vuelos = repository.findByOrigenIdAndDestinoId(idOrigen, idDestino);
        if (vuelos.isEmpty()) {
            return Collections.emptyList();
        }
        return vuelos.stream().map(this::convertToVueloTagDTO).toList();
    }

    private VueloTagDTO convertToVueloTagDTO(Vuelo vuelo) {
        return new VueloTagDTO(
                vuelo.getAvion().getMatricula(),
                vuelo.getId(),
                vuelo.getOrigen().getCiudad().getNombre(),
                vuelo.getOrigen().getNombre(),
                vuelo.getDestino().getCiudad().getNombre(),
                vuelo.getDestino().getNombre()
        );
    }
}
