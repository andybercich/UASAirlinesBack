package org.example.Services;

import org.example.Entities.EstadoMantenimiento;
import org.example.Repositories.EstadoMantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EstadoMantenimientoService extends ServiceGeneric<EstadoMantenimiento, Long, EstadoMantenimientoRepository>{

    @Autowired
    public EstadoMantenimientoService (EstadoMantenimientoRepository repository){this.repository=repository;}


    // Buscar por estado actual del mantenimiento
    public List<EstadoMantenimiento> buscarPorEstadoActual(String estadoActual) {
        return repository.findByEstadoActualIgnoreCase(estadoActual);
    }

    // Buscar estados de mantenimiento con ciclos mayores a un valor dado
    public List<EstadoMantenimiento> buscarPorCiclosMayoresA(int ciclos) {
        return repository.findByCiclosGreaterThan(ciclos);
    }

    // Buscar estados de mantenimiento con horas de vuelo mayores a un valor dado
    public List<EstadoMantenimiento> buscarPorHorasVueloMayoresA(Double horasVuelo) {
        return repository.findByHorasVueloGreaterThan(horasVuelo);
    }

    // Buscar estados de mantenimiento con última inspección antes de una fecha dada
    public List<EstadoMantenimiento> buscarPorFechaUltimoMantenimientoAntesDe(Date fecha) {
        return repository.findByFechaUltimoMantenimientoBefore(fecha);
    }

    // Buscar estados de mantenimiento con próxima inspección después de una fecha dada
    public List<EstadoMantenimiento> buscarPorProximaInspeccionDespuesDe(Date fecha) {
        return repository.findByProximaInspeccionAfter(fecha);
    }

    // Buscar estados de mantenimiento que requieren inspección antes de una fecha específica
    public List<EstadoMantenimiento> buscarPorProximaInspeccionAntesDe(Date fecha) {
        return repository.findByProximaInspeccionBefore(fecha);
    }

    // Buscar estados de mantenimiento donde la última inspección fue hace más de cierto tiempo
    public List<EstadoMantenimiento> buscarPorUltimoMantenimientoAntesDeYProximaInspeccionDespuesDe(Date fechaUltimo, Date fechaProxima) {
        return repository.findByFechaUltimoMantenimientoBeforeAndProximaInspeccionAfter(fechaUltimo, fechaProxima);
    }
}
