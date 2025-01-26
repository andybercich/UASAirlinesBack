package org.example.Services;

import org.example.Entities.Capacitacion;
import org.example.Repositories.CapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CapacitacionService extends ServiceGeneric<Capacitacion,Long, CapacitacionRepository>{

    @Autowired
    public CapacitacionService(CapacitacionRepository capacitacionRepository) {
        this.repository = capacitacionRepository;
    }

    public List<Capacitacion> buscarCapacitacionPorNombre(String nombre) throws Exception {
        try {
            return repository.findByNombreContaining(nombre);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Capacitacion> buscarCapacitacionPorRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFinal) throws Exception {
        try {
            return repository.findByFechaInicioBetween(fechaInicio, fechaFinal);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Capacitacion> buscarCapacitacionPorEmpleado(Long empleadoId) throws Exception {
        try {
            return repository.findByEmpleados_Id(empleadoId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Capacitacion> buscarPorCantidadDeEmpleadosMayorA(int cantidad) throws Exception {
        try {
            return repository.findByCantidadDeEmpleadosMayorA(cantidad);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}