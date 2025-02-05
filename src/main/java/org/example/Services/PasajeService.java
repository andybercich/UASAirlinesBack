package org.example.Services;

import org.example.DTO.PasajeTagDTO;
import org.example.DTO.VueloTagDTO;
import org.example.Entities.Pasaje;
import org.example.Entities.Vuelo;
import org.example.Repositories.PasajeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PasajeService extends ServiceGeneric<Pasaje, Long, PasajeRepository>{

    public PasajeService(PasajeRepository pasajeRepository) {
        this.repository = pasajeRepository;
    }


    public List<PasajeTagDTO> getAllPasajeDTOByIdVuelo (Long id) throws Exception {
        try {

            List<Pasaje> pasajes = repository.findByVueloId(id);

            if (!pasajes.isEmpty()){


                return pasajes.stream().map(this::convertToPasajeTagDTO).toList();

            }else {return Collections.emptyList();}



        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public List<PasajeTagDTO> getAllPasajeDTOByClienteID(Long id) throws Exception {

        try {

            List<Pasaje> pasajes = repository.findByClienteId(id);

            if (!pasajes.isEmpty()){


                return pasajes.stream().map(this::convertToPasajeTagDTO).toList();

            }else {return Collections.emptyList();}



        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public List<PasajeTagDTO> getAllPasajeDTOByIDVueloAndVendidoFalse(Long id) throws Exception {


        try {

            List<Pasaje> pasajes = repository.findByVueloIdAndVendidoFalse(id);

            if (!pasajes.isEmpty()){


                return pasajes.stream().map(this::convertToPasajeTagDTO).toList();

            }else {return Collections.emptyList();}



        }catch (Exception e){
            throw new Exception(e.getMessage());
        }



    }


    public List<PasajeTagDTO> getAllPasajeDTO() throws Exception {

        try {

            List<Pasaje> pasajes = repository.findAll();

            if (!pasajes.isEmpty()){


                return pasajes.stream().map(this::convertToPasajeTagDTO).toList();

            }else {return Collections.emptyList();}



        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }



    private PasajeTagDTO convertToPasajeTagDTO(Pasaje pasaje) {
        return new PasajeTagDTO(
                pasaje.getAsiento(),
                pasaje.getPrecio(),
                pasaje.getClase(),
                pasaje.isVendido()
        );
    }

}