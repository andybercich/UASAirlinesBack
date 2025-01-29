package org.example.Services;

import org.example.DTO.PasajeTagDTO;
import org.example.Entities.Pasaje;
import org.example.Repositories.PasajeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PasajeService extends ServiceGeneric<Pasaje, Long, PasajeRepository>{

    public PasajeService(PasajeRepository pasajeRepository) {
        this.repository = pasajeRepository;
    }


    public List<PasajeTagDTO> getAllPasajeDTOByIdVuelo (Long id) throws Exception {
        try {

            List<Pasaje> pasajes = repository.findByVueloId(id);

            if (!pasajes.isEmpty()){


                return pasajes.stream().map(pasaje -> new PasajeTagDTO(pasaje.getAsiento(), pasaje.getPrecio(),
                        pasaje.getClase(), pasaje.isVendido())).toList();

            }else {throw new Exception("Este vuelo id no tiene ningun pasaje relacionado");}



        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public List<PasajeTagDTO> getAllPasajeDTOByClienteID(Long id) throws Exception {

        try {

            List<Pasaje> pasajes = repository.findByClienteId(id);

            if (!pasajes.isEmpty()){


                return pasajes.stream().map(pasaje -> new PasajeTagDTO(pasaje.getAsiento(), pasaje.getPrecio(),
                        pasaje.getClase(), pasaje.isVendido())).toList();

            }else {throw new Exception("Este cliente id no tiene ningun pasaje relacionado");}



        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public List<PasajeTagDTO> getAllPasajeDTOByIDVueloAndVendidoFalse(Long id) throws Exception {


        try {

            List<Pasaje> pasajes = repository.findByVueloIdAndVendidoFalse(id);

            if (!pasajes.isEmpty()){


                return pasajes.stream().map(pasaje -> new PasajeTagDTO(pasaje.getAsiento(), pasaje.getPrecio(),
                        pasaje.getClase(), pasaje.isVendido())).toList();

            }else {throw new Exception("Este vuelo id no tiene ningun pasaje relacionado");}



        }catch (Exception e){
            throw new Exception(e.getMessage());
        }



    }



}
