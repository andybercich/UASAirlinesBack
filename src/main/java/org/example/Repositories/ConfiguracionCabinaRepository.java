package org.example.Repositories;

import org.example.Entities.ConfiguracionCabina;
import org.example.Entities.enums.Clase;
import org.example.Repositories.RepositorioGenerico;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfiguracionCabinaRepository extends RepositorioGenerico<ConfiguracionCabina, Long> {

    // Buscar por clases disponibles (puede haber múltiples clases en un avión)
    List<ConfiguracionCabina> findByClasesDisponiblesContaining(Clase clase);

}
