package org.example.Services;

import org.example.Entities.Piloto;
import org.example.Repositories.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PilotoService extends ServiceGeneric<Piloto,Long, PilotoRepository>{

    @Autowired
    public PilotoService(PilotoRepository pilotoRepository) {
        this.repository = pilotoRepository;
    }

}