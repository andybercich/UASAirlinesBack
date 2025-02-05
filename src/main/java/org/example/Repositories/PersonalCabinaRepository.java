package org.example.Repositories;

import org.example.Entities.PersonalCabina;
import org.example.Entities.enums.RolCabina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalCabinaRepository extends RepositorioGenerico<PersonalCabina,Long>{

    //Buscar PersonalCabina por idioma especifico
    @Query("SELECT p FROM PersonalCabina p WHERE :idioma MEMBER OF p.idiomas")
    List<PersonalCabina> findByIdioma(@Param("idioma") String idioma);

    //Buscar personal de cabina por rol específico
    List<PersonalCabina> findByRolCabina(RolCabina rolCabina);

    // Buscar personal de cabina por tripulación específica
    List<PersonalCabina> findByTripulacion_Id(Long tripulacionId);

    //Buscar personal de cabina que pertenezca a una tripulación específica y tenga un rol determinado
     List<PersonalCabina> findByTripulacion_IdAndRolCabina(Long tripulacionId, RolCabina rolCabina);

    //Buscar personal de cabina que pertenezca a una tripulación específica y hable un idioma específico
    List<PersonalCabina> findByTripulacion_IdAndIdiomasContaining(Long tripulacionId, String idioma);

    //Buscar personal de cabina que tenga un rol específico y hable un idioma determinado.
    List<PersonalCabina> findByRolCabinaAndIdiomasContaining(RolCabina rolCabina, String idioma);

}