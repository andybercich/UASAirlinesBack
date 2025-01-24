package org.example.Controllers;

import org.example.Entities.AdministradorComercial;
import org.example.Repositories.AdministradorComercialRepository;
import org.example.Services.AdministradorComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admincomercial")
public class AdministradorComercialController extends ControllerGeneric<AdministradorComercial,Long, AdministradorComercialRepository, AdministradorComercialService> {

    @Autowired
    public AdministradorComercialController(AdministradorComercialService service) {
        super(service);
    }

}