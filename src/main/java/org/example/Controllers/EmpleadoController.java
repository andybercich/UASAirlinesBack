package org.example.Controllers;

import org.example.Entities.Empleado;
import org.example.Repositories.EmpleadoRepository;
import org.example.Services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController extends ControllerGeneric<Empleado,Long, EmpleadoRepository, EmpleadoService>{

    @Autowired
    public EmpleadoController(EmpleadoService service) {
        super(service);
    }

}