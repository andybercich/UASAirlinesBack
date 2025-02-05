package org.example.Services;

import org.example.DTO.VueloTagDTO;
import org.example.Entities.Vuelo;
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

    public List<VueloTagDTO> findByAvionId(Long avionId) throws Exception {

        try{

            List<Vuelo> vuelos = repository.findByAvionId(avionId);
            if (vuelos.isEmpty()) {
                return Collections.emptyList();
            }
            return vuelos.stream().map(this::convertToVueloTagDTO).toList();

        }catch (Exception e){

            throw new Exception(e.getMessage());

        }

    }

    public List<VueloTagDTO> findByOrigenId(Long origenId) throws Exception {

        try{
            List<Vuelo> vuelos = repository.findByOrigenId(origenId);
            if (vuelos.isEmpty()) {
                return Collections.emptyList();
            }
            return vuelos.stream().map(this::convertToVueloTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }

    }

    public List<VueloTagDTO> findByDestinoId(Long destinoId) throws Exception {

        try{
            List<Vuelo> vuelos = repository.findByDestinoId(destinoId);
            if (vuelos.isEmpty()) {
                return Collections.emptyList();
            }
            return vuelos.stream().map(this::convertToVueloTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }

    }

    public List<VueloTagDTO> findByOrigenIdAndDestinoId(Long origenId, Long destinoId) throws Exception {

        try{
            List<Vuelo> vuelos = repository.findByOrigenIdAndDestinoId(origenId, destinoId);
            if (vuelos.isEmpty()) {
                return Collections.emptyList();
            }
            return vuelos.stream().map(this::convertToVueloTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }

    public List<VueloTagDTO> findByEscalasAeropuertoId(Long aeropuertoId) throws Exception {

        try{
            List<Vuelo> vuelos = repository.findByEscalasAeropuertoId(aeropuertoId);
            if (vuelos.isEmpty()) {
                return Collections.emptyList();
            }
            return vuelos.stream().map(this::convertToVueloTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }

    public List<VueloTagDTO> findByConEscalaTrue() throws Exception {

        try{
            List<Vuelo> vuelos = repository.findByConEscalaTrue();
            if (vuelos.isEmpty()) {
                return Collections.emptyList();
            }
            return vuelos.stream().map(this::convertToVueloTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }

    public List<VueloTagDTO> findByConEscalaFalse() throws Exception {

        try{

            List<Vuelo> vuelos = repository.findByConEscalaFalse();
            if (vuelos.isEmpty()) {
                return Collections.emptyList();
            }
            return vuelos.stream().map(this::convertToVueloTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }

    }


    public List<VueloTagDTO> findByTipoOperacion(TipoOperacion tipoOperacion) throws Exception {

        try{
            List<Vuelo> vuelos = repository.findByTipoOperacion(tipoOperacion);
            if (vuelos.isEmpty()) {
                return Collections.emptyList();
            }
            return vuelos.stream().map(this::convertToVueloTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }

    public List<VueloTagDTO> findByFechaHoraLlegadaBefore(ZonedDateTime fechaHoraLlegada) throws Exception {

        try{
            List<Vuelo> vuelos = repository.findByFechaHoraLlegadaBefore(fechaHoraLlegada);
            if (vuelos.isEmpty()) {
                return Collections.emptyList();
            }
            return vuelos.stream().map(this::convertToVueloTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }

    public List<VueloTagDTO> findByFechaHoraSalidaAfter(ZonedDateTime fechaHoraSalida) throws Exception {

        try{
            List<Vuelo> vuelos = repository.findByFechaHoraSalidaAfter(fechaHoraSalida);
            if (vuelos.isEmpty()) {
                return Collections.emptyList();
            }
            return vuelos.stream().map(this::convertToVueloTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }

    public List<VueloTagDTO> findByFechaHoraSalidaBetween(ZonedDateTime startDate, ZonedDateTime endDate) throws Exception {

        try{
            List<Vuelo> vuelos = repository.findByFechaHoraSalidaBetween(startDate, endDate);
            if (vuelos.isEmpty()) {
                return Collections.emptyList();
            }
            return vuelos.stream().map(this::convertToVueloTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }

    public VueloTagDTO findVueloDTOById(Long aLong) throws Exception {
        return convertToVueloTagDTO(super.findById(aLong));
    }

    public List<VueloTagDTO> findVueloDTOAll() throws Exception {
        return super.findAll().stream().map(this::convertToVueloTagDTO).toList();
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
