package org.example.Controllers;

import org.example.Entities.PersonalCabina;
import org.example.Repositories.PersonalCabinaRepository;
import org.example.Services.PersonalCabinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personalcabina")
public class PersonalCabinaController extends ControllerGeneric<PersonalCabina,Long, PersonalCabinaRepository, PersonalCabinaService>{

    @Autowired
    public PersonalCabinaController(PersonalCabinaService service) {
        super(service);
    }

}