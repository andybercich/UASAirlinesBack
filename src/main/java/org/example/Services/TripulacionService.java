package org.example.Services;

import org.example.Entities.Piloto;
import org.example.Entities.Tripulacion;
import org.example.Entities.enums.EstadoTripulacion;
import org.example.Repositories.TripulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Tripulacion> buscarTripulacionPorCapacitacionAntesDe(Date fecha) throws Exception{
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

    public List<Tripulacion> buscarTripulacionPorPersonalCabina(Long personalCabinaId) throws Exception{
        try {
            return repository.findByPersonalCabina(personalCabinaId);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Tripulacion> buscarPorIdiomaPersonalCabina(String idioma) throws Exception{
        try {
            return repository.findByIdiomaPersonalCabina(idioma);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}