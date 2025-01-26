package org.example.Services;

import org.example.Entities.Empleado;
import org.example.Repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmpleadoService extends ServiceGeneric<Empleado,Long, EmpleadoRepository>{

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.repository = empleadoRepository;
    }

    public List<Empleado> porRangoFechaIncorporacion(Date inicio, Date fin) throws Exception{
        try{
            return repository.findByIncorporacionBetween(inicio, fin);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Empleado> porContratoProntoVencerAntes (Date fecha) throws Exception{
        try{
            return repository.findByVencimientoContratoBefore(fecha);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}