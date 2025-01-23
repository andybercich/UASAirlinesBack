package org.example.Controllers;

import org.example.Entities.AdministradorComercial;
import org.example.Services.AdministradorComercialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdministradorController extends ControllerGeneric<AdministradorComercial,Long, AdministradorRepo,
        AdministradorComercialService> {
    public AdministradorController(AdministradorComercialService service) {
        super(service);
    }
}
