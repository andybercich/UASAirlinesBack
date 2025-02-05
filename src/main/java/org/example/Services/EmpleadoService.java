package org.example.Services;

import org.example.Entities.Empleado;
import org.example.Entities.enums.EstadoCivil;
import org.example.Repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EmpleadoService extends ServiceGeneric<Empleado,Long, EmpleadoRepository>{

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.repository = empleadoRepository;
    }

   public List<Empleado> porRangoFechaIncorporacion(LocalDate inicio, LocalDate fin) throws Exception{
        try{
            return repository.findByIncorporacionBetween(inicio, fin);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Empleado> porContratoProntoVencerAntes (LocalDate fecha) throws Exception{
        try{
            return repository.findByVencimientoContratoBefore(fecha);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Empleado> porEstadoCivil (EstadoCivil estado) throws Exception{
        try{
            return repository.findByEstadoCivil(estado);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}