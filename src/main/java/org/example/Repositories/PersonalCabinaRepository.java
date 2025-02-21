package org.example.Repositories;

import org.example.Entities.PersonalCabina;
import org.example.Entities.enums.RolCabina;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalCabinaRepository extends RepositorioGenerico<PersonalCabina,Long>{

    //Buscar PersonalCabina por idioma especifico
    List<PersonalCabina> findByIdiomaId(@Param("idioma") Long idioma);

    //Buscar personal de cabina por rol específico
    List<PersonalCabina> findByRolCabina(RolCabina rolCabina);

    // Buscar personal de cabina por tripulación específica
    List<PersonalCabina> findByTripulacion_Id(Long tripulacionId);

    //Buscar personal de cabina que pertenezca a una tripulación específica y tenga un rol determinado
     List<PersonalCabina> findByTripulacion_IdAndRolCabina(Long tripulacionId, RolCabina rolCabina);

    //Buscar personal de cabina que pertenezca a una tripulación específica y hable un idioma específico
    List<PersonalCabina> findByTripulacion_IdAndIdiomaIdContaining(Long tripulacionId, Long id_idioma);

    //Buscar personal de cabina que tenga un rol específico y hable un idioma determinado.
    List<PersonalCabina> findByRolCabinaAndIdiomaIdContaining(RolCabina rolCabina, Long idioma);

}