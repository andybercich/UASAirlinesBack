package org.example.Repositories;

import org.example.Entities.Empleado;
import org.example.Entities.enums.EstadoCivil;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EmpleadoRepository extends RepositorioGenerico<Empleado,Long>{

    //Buscar empleados por rango de fecha de incorporación
    List<Empleado> findByIncorporacionBetween(LocalDate inicio, LocalDate fin);

    //Buscar empleados cuyo contrato vence pronto antes de una fecha especifica
    List<Empleado> findByVencimientoContratoBefore(LocalDate fecha);

    //Buscar empledados por estado civil
    List<Empleado> findByEstadoCivil(EstadoCivil estadoCivil);

}