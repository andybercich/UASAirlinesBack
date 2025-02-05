package org.example.Services;

import org.example.DTO.VueloTagDTO;
import org.example.Entities.Ciudad;
import org.example.Entities.Vuelo;
import org.example.Repositories.CiudadRepository;
import org.example.Repositories.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CiudadService extends ServiceGeneric<Ciudad, Long, CiudadRepository>{

    public CiudadService(CiudadRepository ciudadRepository) {
        this.repository = ciudadRepository;
    }


    public List<Ciudad> findByPaisId(Long id) throws Exception {


            try{

                List<Ciudad> ciudades = repository.findByPaisId(id);
                if (ciudades.isEmpty()) {
                    return Collections.emptyList();
                }
                return ciudades;

            }catch (Exception e){
                throw new Exception(e.getMessage());
            }


    }



}
