package org.example.Repositories;

import org.example.Entities.Mantenimiento;
import org.example.Entities.EstadoMantenimiento;
import org.example.Entities.Supervisor;
import org.example.Entities.Tecnico;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MantenimientoRepository extends RepositorioGenerico<Mantenimiento, Long> {

    // Buscar mantenimientos por estado
    List<Mantenimiento> findByEstadoMantenimiento(EstadoMantenimiento estado);

    // Buscar mantenimientos programados
    List<Mantenimiento> findByProgramadaTrue();

    // Buscar mantenimientos no programados
    List<Mantenimiento> findByProgramadaFalse();

    // Buscar mantenimientos por supervisor
    List<Mantenimiento> findBySupervisor(Supervisor supervisor);

    // Buscar mantenimientos por técnico
    List<Mantenimiento> findByTecnicosContaining(Tecnico tecnico);

    // Buscar mantenimientos iniciados después de una fecha específica
    List<Mantenimiento> findByInicioAfter(Date fecha);

    // Buscar mantenimientos finalizados antes de una fecha específica
    List<Mantenimiento> findByFinBefore(Date fecha);
}