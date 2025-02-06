package org.example.Controllers;

import org.example.Entities.Aeropuerto;
import org.example.Entities.Avion;
import org.example.Entities.EstadoMantenimiento;
import org.example.Entities.enums.EstadoAvion;
import org.example.Repositories.AvionRepository;
import org.example.Services.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aviones")
public class AvionController extends ControllerGeneric<Avion, Long, AvionRepository, AvionService> {

    @Autowired
    public AvionController(AvionService avionService) {
        super(avionService);
    }

    // Buscar aviones por matrícula
    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Avion> buscarPorMatricula(@PathVariable String matricula) {
        try {
            Optional<Avion> avion = service.buscarPorMatricula(matricula);
            return avion.isPresent() ? ResponseEntity.ok(avion.get()) :
                    ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar aviones por modelo
    @GetMapping("/modelo")
    public ResponseEntity<List<Avion>> buscarPorModelo(@RequestParam String modelo) {
        try {
            List<Avion> aviones = service.buscarPorModelo(modelo);
            return ResponseEntity.ok(aviones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar aviones por fabricante
    @GetMapping("/fabricante")
    public ResponseEntity<List<Avion>> buscarPorFabricante(@RequestParam String fabricante) {
        try {
            List<Avion> aviones = service.buscarPorFabricante(fabricante);
            return ResponseEntity.ok(aviones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar aviones por estado
    @GetMapping("/estado")
    public ResponseEntity<List<Avion>> buscarPorEstado(@RequestParam EstadoAvion estado) {
        try {
            List<Avion> aviones = service.buscarPorEstado(estado);
            return ResponseEntity.ok(aviones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar aviones con cantidad de asientos mayor a X
    @GetMapping("/asientos-mayor")
    public ResponseEntity<List<Avion>> buscarPorCantidadAsientosMayorA(@RequestParam int cantidad) {
        try {
            List<Avion> aviones = service.buscarPorCantidadAsientosMayorA(cantidad);
            return ResponseEntity.ok(aviones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar aviones con rango de vuelo mayor a X km
    @GetMapping("/rango-vuelo-mayor")
    public ResponseEntity<List<Avion>> buscarPorRangoVueloMayorA(@RequestParam double rangoVuelo) {
        try {
            List<Avion> aviones = service.buscarPorRangoVueloMayorA(rangoVuelo);
            return ResponseEntity.ok(aviones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar aviones que necesiten mantenimiento
    @GetMapping("/mantenimiento")
    public ResponseEntity<List<Avion>> buscarPorEstadoMantenimiento(@RequestParam EstadoMantenimiento estadoMantenimiento) {
        try {
            List<Avion> aviones = service.buscarPorEstadoMantenimiento(estadoMantenimiento);
            return ResponseEntity.ok(aviones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    // Contar aviones en un aeropuerto específico
    @GetMapping("/contar/aeropuerto")
    public ResponseEntity<Long> contarAvionesPorAeropuerto(@RequestParam Aeropuerto aeropuerto) {
        try {
            long count = service.contarPorUbicacionActual(aeropuerto);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}