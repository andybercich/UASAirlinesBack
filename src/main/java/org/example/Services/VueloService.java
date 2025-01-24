package org.example.Services;

import org.example.DTO.VueloTagDTO;
import org.example.Entities.Vuelo;
import org.example.Repositories.PasajeRepository;
import org.example.Repositories.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VueloService extends ServiceGeneric<Vuelo, Long, VueloRepository>{

    public VueloService(VueloRepository vueloRepository) {
        this.repository = vueloRepository;
    }


    public List<VueloTagDTO> getAllVueloDTOTagByOrigneAndDestino(Long idOrigen, Long idDestino) throws Exception {

        List<Vuelo> vuelos;
        try {
            vuelos = repository.findByOrigenIdAndDestinoId(idOrigen, idDestino);

            if (vuelos.isEmpty()) {
                throw new Exception("No hay vuelos con ese destino");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return vuelos.stream().map(vuelo -> new VueloTagDTO(
                vuelo.getAvion().getMatricula(),
                vuelo.getId(),
                vuelo.getOrigen().getCiudad().getNombre(),
                vuelo.getOrigen().getNombre(),
                vuelo.getDestino().getCiudad().getNombre(),
                vuelo.getDestino().getNombre())).toList();

    }



}
