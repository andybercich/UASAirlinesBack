package org.example.Controllers;

import org.example.Entities.Capacitacion;
import org.example.Repositories.CapacitacionRepository;
import org.example.Services.CapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/capacitaciones")
public class CapacitacionContoller extends ControllerGeneric<Capacitacion,Long, CapacitacionRepository, CapacitacionService> {

    @Autowired
    public CapacitacionContoller(CapacitacionService service) {
        super(service);
    }

}