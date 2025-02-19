package org.example.Services;

import org.example.Entities.Mantenimiento;
import org.example.Entities.EstadoMantenimiento;
import org.example.Entities.Supervisor;
import org.example.Entities.Tecnico;
import org.example.Repositories.MantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MantenimientoService extends ServiceGeneric<Mantenimiento, Long, MantenimientoRepository> {

    @Autowired
    public MantenimientoService(MantenimientoRepository mantenimientoRepository) {
        this.repository = mantenimientoRepository;
    }

    public List<Mantenimiento> buscarPorEstado(EstadoMantenimiento estado) {
        return repository.findByEstadoMantenimiento(estado);
    }

    public List<Mantenimiento> buscarProgramados() {
        return repository.findByProgramadoTrue();
    }

    public List<Mantenimiento> buscarNoProgramados() {
        return repository.findByProgramadoFalse();
    }

    public List<Mantenimiento> buscarPorSupervisor(Supervisor supervisor) {
        return repository.findBySupervisor(supervisor);
    }

    public List<Mantenimiento> buscarPorTecnico(Tecnico tecnico) {
        return repository.findByTecnicosContaining(tecnico);
    }

    public List<Mantenimiento> buscarIniciadosDespuesDe(Date fecha) {
        return repository.findByInicioAfter(fecha);
    }

    public List<Mantenimiento> buscarFinalizadosAntesDe(Date fecha) {
        return repository.findByFinBefore(fecha);
    }
}