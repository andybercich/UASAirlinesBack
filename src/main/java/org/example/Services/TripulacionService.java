package org.example.Services;

import org.example.Entities.Piloto;
import org.example.Entities.Tripulacion;
import org.example.Entities.enums.EstadoTripulacion;
import org.example.Repositories.TripulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TripulacionService extends ServiceGeneric<Tripulacion,Long, TripulacionRepository>{

    @Autowired
    public TripulacionService(TripulacionRepository tripulacionRepository) {
        this.repository = tripulacionRepository;
    }

    public List<Tripulacion> buscarTripulacionEstado(EstadoTripulacion estado) throws Exception{
        try{
            return repository.findByEstado(estado);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Tripulacion> buscarTripulacionPorCapacitacionAntesDe(LocalDate fecha) throws Exception{
        try {
            return repository.findByProximaCapacitacionBefore(fecha);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Tripulacion> buscarTripulacionPorCapitan(Piloto capitan) throws Exception{
        try {
            return repository.findByCapitan(capitan);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Tripulacion> buscarPorCapitanyEstadoTripulacion(Piloto capitan,EstadoTripulacion estadoTripulacion) throws Exception{
        try {
            return repository.findByCapitanAndEstado(capitan,estadoTripulacion);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Tripulacion> buscarTripulacionPorCopiloto(Piloto copiloto) throws Exception{
        try {
            return repository.findByCopiloto(copiloto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}