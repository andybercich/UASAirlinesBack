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
            return repository.findByIdioma(idioma);
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

    public List<PersonalCabina> buscarPersonalPorTripulacionyRol(Long tripulacionId,RolCabina rol) throws Exception{
        try {
            return repository.findByTripulacion_IdAndRolCabina(tripulacionId,rol);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<PersonalCabina> buscarPersonalPorTripulacionyIdioma(Long tripulacionId,String idioma) throws Exception{
        try {
            return repository.findByTripulacion_IdAndIdiomasContaining(tripulacionId,idioma);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<PersonalCabina> buscarPersonalPorRolyIdioma(RolCabina rol, String idioma) throws Exception{
        try {
            return repository.findByRolCabinaAndIdiomasContaining(rol,idioma);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }





}