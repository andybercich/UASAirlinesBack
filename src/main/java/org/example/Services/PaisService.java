package org.example.Services;

import org.example.Entities.Ciudad;
import org.example.Entities.Pais;
import org.example.Entities.enums.Continente;
import org.example.Repositories.CiudadRepository;
import org.example.Repositories.PaisRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PaisService extends ServiceGeneric<Pais, Long, PaisRepository>{

    public PaisService(PaisRepository paisRepository) {
        this.repository = paisRepository;
    }



    public List<Pais> findByContinente(Continente continente) throws Exception {


        try{

            List<Pais> paises = repository.findByContinente(continente);
            if (paises.isEmpty()) {
                return Collections.emptyList();
            }
            return paises;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }




}
