package org.example.Services;

import org.example.Entities.PersonalCabina;
import org.example.Entities.enums.RolCabina;
import org.example.Repositories.PersonalCabinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalCabinaService extends ServiceGeneric<PersonalCabina,Long, PersonalCabinaRepository>{

    @Autowired
    public PersonalCabinaService(PersonalCabinaRepository personalCabinaRepository) {
        this.repository = personalCabinaRepository;
    }

    public List<PersonalCabina> buscarPersonalPorIdioma(String idioma) throws Exception{
        try {
            return repository.findByIdiomasContaining(idioma);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<PersonalCabina> buscarPersonalPorRolEspecifico(RolCabina rolCabina) throws Exception{
        try {
            return repository.findByRolCabina(rolCabina);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<PersonalCabina> buscarPersonalPorTripulacion(Long tripulacionId) throws Exception{
        try {
            return repository.findByTripulacion_Id(tripulacionId);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<PersonalCabina> buscarPersonalConIdiomayRolEspecifico(String idioma,RolCabina rolCabina) throws Exception{
        try {
            return repository.findByIdiomaAndRol(idioma,rolCabina);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    public List<PersonalCabina> buscarPersonalConDosIdiomas(String idioma1,String idioma2) throws Exception{
        try {
            return repository.findByIdiomas(idioma1,idioma2);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}