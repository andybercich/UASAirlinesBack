package org.example.Services;

import org.example.DTO.EscalaTagDTO;
import org.example.DTO.VueloTagDTO;
import org.example.Entities.Escala;
import org.example.Entities.Vuelo;
import org.example.Repositories.EscalaRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class EscalaService extends ServiceGeneric<Escala, Long, EscalaRepository>{


    public List<EscalaTagDTO> findByVueloId(Long id) throws Exception {

        try{
            List<Escala> escalas = repository.findByVueloId(id);
            if (escalas.isEmpty()) {
                return Collections.emptyList();
            }
            return escalas.stream().map(this::convertToEscalaTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }


    public List<EscalaTagDTO> findByAeropuertoID(Long id) throws Exception {

        try{
            List<Escala> escalas = repository.findByAeropuertoId(id);
            if (escalas.isEmpty()) {
                return Collections.emptyList();
            }
            return escalas.stream().map(this::convertToEscalaTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }


    //Sirve para encontrar las escalas despues de una de llegada
    public List<EscalaTagDTO> findByLlegadaAfter(ZonedDateTime llegada) throws Exception {

        try{
            List<Escala> escalas = repository.findByLlegadaAfter(llegada);
            if (escalas.isEmpty()) {
                return Collections.emptyList();
            }
            return escalas.stream().map(this::convertToEscalaTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }

    //Sirve para encontrar las escalas antes de una fecha salida
    public List<EscalaTagDTO> findBySalidaBefore(ZonedDateTime salida) throws Exception {

        try{
            List<Escala> escalas = repository.findBySalidaBefore(salida);
            if (escalas.isEmpty()) {
                return Collections.emptyList();
            }
            return escalas.stream().map(this::convertToEscalaTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }


    //Sirve para encontrar las escalas dentro de fechas de llegada y salida
    public List<EscalaTagDTO> findByLlegadaBetween(ZonedDateTime llegada, ZonedDateTime salida) throws Exception {

        try{
            List<Escala> escalas = repository.findByLlegadaBetween(llegada, salida);
            if (escalas.isEmpty()) {
                return Collections.emptyList();
            }
            return escalas.stream().map(this::convertToEscalaTagDTO).toList();
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }


    }





    private EscalaTagDTO convertToEscalaTagDTO(Escala escala) {
        return new EscalaTagDTO(
                escala.getLlegada(),
                escala.getSalida(),
                escala.getVuelo().getAvion().getMatricula(),
                escala.getAeropuerto().getCiudad().getNombre(),
                escala.getAeropuerto().getNombre()
        );
    }
}
