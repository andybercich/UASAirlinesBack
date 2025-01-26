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
    List<PersonalCabina> findByIdiomasContaining(String idioma);

    //Buscar personal de cabina por rol específico
    List<PersonalCabina> findByRolCabina(RolCabina rolCabina);

    //Buscar personal de cabina que hable múltiples idiomas (lista de idiomas)
    /*@Query("SELECT p FROM PersonalCabina p WHERE :idioma IN elements(p.idiomas)")
    List<PersonalCabina> findByMultipleIdiomas(@Param("idioma") String idioma);*/

    // Buscar personal de cabina por tripulación específica
    List<PersonalCabina> findByTripulacion_Id(Long tripulacionId);

    //Buscar personal que hable un idioma y tenga un rol específico
    @Query("SELECT p FROM PersonalCabina p WHERE :idioma IN elements(p.idiomas) AND p.rolCabina = :rolCabina")
    List<PersonalCabina> findByIdiomaAndRol(@Param("idioma") String idioma, @Param("rolCabina") RolCabina rolCabina);

    //Buscar personalCabina que hable dos idiomas especificos
    @Query("SELECT p FROM PersonalCabina p WHERE :idioma1 IN elements(p.idiomas) AND :idioma2 IN elements(p.idiomas)")
    List<PersonalCabina> findByIdiomas(@Param("idioma1") String idioma1, @Param("idioma2") String idioma2);

}