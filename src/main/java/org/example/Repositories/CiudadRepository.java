package org.example.Repositories;

import org.example.Entities.Ciudad;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepository extends RepositorioGenerico<Ciudad, Long>{

    List<Ciudad> findByPaisId(Long paisId);

}
