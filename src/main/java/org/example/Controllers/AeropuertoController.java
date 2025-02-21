package org.example.Controllers;

import org.example.Entities.Aeropuerto;
import org.example.Repositories.AeropuertoRepository;
import org.example.Services.AeropuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aeropuertos")
public class AeropuertoController extends ControllerGeneric<Aeropuerto,Long, AeropuertoRepository, AeropuertoService>{

    @Autowired
    public AeropuertoController(AeropuertoService aeropuertoService) {
        super(aeropuertoService);
    }


    // Buscar aeropuerto por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Aeropuerto>> buscarPorNombre(@PathVariable String nombre) {
        try {
            List<Aeropuerto> aeropuertos = service.buscarPorNombre(nombre);
            return ResponseEntity.ok(aeropuertos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar aeropuertos por ciudad
    @GetMapping("/ciudad")
    public ResponseEntity<List<Aeropuerto>> buscarPorCiudad(@RequestParam String ciudadNombre) {
        try {
            List<Aeropuerto> aeropuertos = service.buscarPorCiudad(ciudadNombre);
            return ResponseEntity.ok(aeropuertos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    // Buscar aeropuertos con vuelos hacia una ciudad específica
    @GetMapping("/destino")
    public ResponseEntity<List<Aeropuerto>> buscarPorDestinoCiudad(@RequestParam String ciudadNombre) {
        try {
            List<Aeropuerto> aeropuertos = service.buscarPorDestinoCiudad(ciudadNombre);
            return ResponseEntity.ok(aeropuertos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar aeropuertos con vuelos desde una ciudad específica
    @GetMapping("/origen")
    public ResponseEntity<List<Aeropuerto>> buscarPorOrigenCiudad(@RequestParam String ciudadNombre) {
        try {
            List<Aeropuerto> aeropuertos = service.buscarPorOrigenCiudad(ciudadNombre);
            return ResponseEntity.ok(aeropuertos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    // Buscar aeropuertos con escalas en vuelos con un destino específico
    @GetMapping("/escalas")
    public ResponseEntity<List<Aeropuerto>> aeropuertosConEscalasEnDestino(@RequestParam String ciudadNombre) {
        try {
            List<Aeropuerto> aeropuertos = service.aeropuertosConEscalasEnDestino(ciudadNombre);
            return ResponseEntity.ok(aeropuertos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
