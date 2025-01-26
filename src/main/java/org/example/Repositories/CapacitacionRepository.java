package org.example.Repositories;

import org.example.Entities.Capacitacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CapacitacionRepository extends RepositorioGenerico<Capacitacion,Long> {

    //Buscar capacitaciones por nombre
    List<Capacitacion> findByNombreContaining(String nombre);

    //Obtener capacitaciones entre fechas específicas
    List<Capacitacion> findByFechaInicioBetween(LocalDate fechaInicio, LocalDate fechaFinal);

    //Buscar capacitaciones por empleado
    List<Capacitacion> findByEmpleados_Id(Long empleadoId);

    //Capacitaciones con más de X empleados inscritos
    @Query("SELECT c FROM Capacitacion c WHERE SIZE(c.empleados) > :cantidad")
    List<Capacitacion> findByCantidadDeEmpleadosMayorA(@Param("cantidad") int cantidad);

}