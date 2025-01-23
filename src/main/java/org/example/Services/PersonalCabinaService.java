package org.example.Services;

import org.example.Entities.PersonalCabina;
import org.example.Repositories.PersonalCabinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalCabinaService extends ServiceGeneric<PersonalCabina,Long, PersonalCabinaRepository>{

    @Autowired
    public PersonalCabinaService(PersonalCabinaRepository personalCabinaRepository) {
        this.repository = personalCabinaRepository;
    }

}