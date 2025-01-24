package org.example.Controllers;

import org.example.Entities.Piloto;
import org.example.Repositories.PilotoRepository;
import org.example.Services.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pilotos")
public class PilotoController extends ControllerGeneric<Piloto,Long, PilotoRepository, PilotoService>{

    @Autowired
    public PilotoController(PilotoService service) {
        super(service);
    }

}