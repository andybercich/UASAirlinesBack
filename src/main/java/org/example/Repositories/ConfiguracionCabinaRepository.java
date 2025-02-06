package org.example.Repositories;

import org.example.Entities.ConfiguracionCabina;
import org.example.Repositories.RepositorioGenerico;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfiguracionCabinaRepository extends RepositorioGenerico<ConfiguracionCabina, Long> {

    // Buscar por clases disponibles (puede haber múltiples clases en un avión)
    List<ConfiguracionCabina> findByClasesDisponiblesContaining(String clase);

    // Buscar configuraciones que tengan un sistema de entretenimiento específico
    List<ConfiguracionCabina> findByEntretenimiento(String entretenimiento);

    // Buscar configuraciones que incluyan un sistema de comunicación específico
    List<ConfiguracionCabina> findBySistemasComunicacion(String sistemasComunicacion);

    // Buscar configuraciones con ciertas modificaciones realizadas
    List<ConfiguracionCabina> findByModificacionesRealizadasContaining(String modificacion);

    // Buscar configuraciones que cuenten con un sistema de seguridad específico
    List<ConfiguracionCabina> findBySistemaSeguridad(String sistemaSeguridad);
}
