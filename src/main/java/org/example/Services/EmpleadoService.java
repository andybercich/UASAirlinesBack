package org.example.Services;

import org.example.Entities.Empleado;
import org.example.Repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService extends ServiceGeneric<Empleado,Long, EmpleadoRepository>{

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.repository = empleadoRepository;
    }

}