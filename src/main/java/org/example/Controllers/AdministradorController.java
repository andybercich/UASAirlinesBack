package org.example.Controllers;

import org.example.Entities.AdministradorComercial;
import org.example.Repositories.AdministradorRepo;
import org.example.Services.AdministradorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdministradorController extends ControllerGeneric<AdministradorComercial,Long, AdministradorRepo,
        AdministradorService> {
    public AdministradorController(AdministradorService service) {
        super(service);
    }
}
