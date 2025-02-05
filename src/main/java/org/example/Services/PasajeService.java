package org.example.Services;

import org.example.Entities.Pasaje;
import org.example.Repositories.PasajeRepository;

public class PasajeService extends ServiceGeneric<Pasaje, Long, PasajeRepository>{

    public PasajeService(PasajeRepository pasajeRepository) {
        this.repository = pasajeRepository;
    }




}
