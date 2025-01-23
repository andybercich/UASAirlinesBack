package org.example.Services;

import org.example.Entities.Tripulacion;
import org.example.Repositories.TripulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripulacionService extends ServiceGeneric<Tripulacion,Long, TripulacionRepository>{

    @Autowired
    public TripulacionService(TripulacionRepository tripulacionRepository) {
        this.repository = tripulacionRepository;
    }

}