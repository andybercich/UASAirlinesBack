package org.example.Services;

import org.example.Entities.Aeropuerto;
import org.example.Repositories.AeropuertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeropuertoService extends ServiceGeneric<Aeropuerto, Long, AeropuertoRepository>{

    @Autowired
    public AeropuertoService (AeropuertoRepository repository){this.repository = repository;}


    public List<Aeropuerto> buscarPorNombre(String nombre) {
        return repository.findByNombreIgnoreCase(nombre);
    }

    public List<Aeropuerto> buscarPorCiudad(String ciudadNombre) {
        return repository.findByCiudadNombreIgnoreCase(ciudadNombre);
    }

    public List<Aeropuerto> buscarPorDestinoCiudad(String ciudadNombre) {
        return repository.findByDestinoCiudad(ciudadNombre);
    }

    public List<Aeropuerto> buscarPorOrigenCiudad(String ciudadNombre) {
        return repository.findByOrigenCiudad(ciudadNombre);
    }


    public List<Aeropuerto> aeropuertosConEscalasEnDestino(String ciudadNombre) {
        return repository.findAeropuertosConEscalasEnDestino(ciudadNombre);
    }



}
