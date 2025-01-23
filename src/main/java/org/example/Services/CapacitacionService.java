package org.example.Services;

import org.example.Entities.Capacitacion;
import org.example.Repositories.CapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapacitacionService extends ServiceGeneric<Capacitacion,Long, CapacitacionRepository>{

    @Autowired
    public CapacitacionService(CapacitacionRepository capacitacionRepository) {
        this.repository = capacitacionRepository;
    }

}