package org.example.Repositories;

import org.example.Entities.Empleado;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmpleadoRepository extends RepositorioGenerico<Empleado,Long>{

    //Buscar empleados por rango de fecha de incorporación
    List<Empleado> findByIncorporacionBetween(Date inicio, Date fin);

    //Buscar empleados cuyo contrato vence pronto
    List<Empleado> findByVencimientoContratoBefore(Date fecha);

}