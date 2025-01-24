package org.example.Repositories;

import org.example.Entities.Pais;
import org.example.Entities.enums.Continente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepository extends RepositorioGenerico<Pais, Long>{
    List<Pais> findByContinente(Continente continente);

}
