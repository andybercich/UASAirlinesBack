package org.example.Controllers;

import org.example.Entities.Tripulacion;
import org.example.Repositories.TripulacionRepository;
import org.example.Services.TripulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tripulacion")
public class TripulacionController extends ControllerGeneric<Tripulacion,Long, TripulacionRepository, TripulacionService>{

    @Autowired
    public TripulacionController(TripulacionService service) {
        super(service);
    }

}