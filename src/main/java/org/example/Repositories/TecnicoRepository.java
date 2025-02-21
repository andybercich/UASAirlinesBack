package org.example.Repositories;

import org.example.Entities.Mantenimiento;
import org.example.Entities.Tecnico;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TecnicoRepository extends RepositorioGenerico<Tecnico, Long> {

    // Buscar por tipo de licencia
    List<Tecnico> findByTipoLicencia(String tipoLicencia);

    // Buscar por fecha de vencimiento de licencia antes de una fecha
    List<Tecnico> findByVencimientoLicenciaBefore(Date fecha);

    // Buscar por fecha de vencimiento de licencia después de una fecha
    List<Tecnico> findByVencimientoLicenciaAfter(Date fecha);

    // Buscar técnicos asociados a un mantenimiento específico
    List<Tecnico> findByMantenimientos(Mantenimiento mantenimiento);

    // Buscar técnicos con licencia vencida
    long countByVencimientoLicenciaBefore(Date fecha);

    // Buscar técnicos cuyo nombre contenga un texto específico (sin distinguir mayúsculas/minúsculas)
    List<Tecnico> findByNombreContainingIgnoreCase(String nombre);

}

