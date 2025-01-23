package org.example.Services;

import org.example.Entities.Persona;
import org.example.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService extends ServiceGeneric<Persona, Long, PersonaRepository>{

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.repository = personaRepository;
    }

}