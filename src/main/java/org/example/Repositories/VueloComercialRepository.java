package org.example.Repositories;

import org.example.Entities.Pasaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloComercialRepository extends RepositorioGenerico<org.example.Entities.VueloComercial, Long>{


    @Query("SELECT p FROM Pasaje p WHERE p.vuelo.id = :vueloId")
    List<Pasaje> findAllPasajesByVueloId(@Param("vueloId") Long vueloId);

    @Query("SELECT p FROM Pasaje p WHERE p.vuelo.id = :vueloId AND p.vendido = true")
    List<Pasaje> findPasajesVendidosByVueloId(@Param("vueloId") Long vueloId);

    @Query("SELECT p FROM Pasaje p WHERE p.vuelo.id = :vueloId AND p.vendido = false")
    List<Pasaje> findPasajesNoVendidosByVueloId(@Param("vueloId") Long vueloId);

}
