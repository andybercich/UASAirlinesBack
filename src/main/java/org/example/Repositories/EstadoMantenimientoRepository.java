package org.example.Repositories;

import org.example.Entities.EstadoMantenimiento;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EstadoMantenimientoRepository extends RepositorioGenerico<EstadoMantenimiento, Long>{


    List<EstadoMantenimiento> findByEstadoActualIgnoreCase(String estadoActual);

    List<EstadoMantenimiento> findByCiclosGreaterThan(int ciclos);

    List<EstadoMantenimiento> findByHorasVueloGreaterThan(Double horasVuelo);

    List<EstadoMantenimiento> findByFechaUltimoMantenimientoBefore(Date fecha);

    List<EstadoMantenimiento> findByProximaInspeccionAfter(Date fecha);

    List<EstadoMantenimiento> findByProximaInspeccionBefore(Date fecha);

    List<EstadoMantenimiento> findByFechaUltimoMantenimientoBeforeAndProximaInspeccionAfter(Date fechaUltimo, Date fechaProxima);

}
