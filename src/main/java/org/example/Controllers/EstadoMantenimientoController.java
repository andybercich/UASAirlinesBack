package org.example.Controllers;

import org.example.Entities.EstadoMantenimiento;
import org.example.Repositories.EstadoMantenimientoRepository;
import org.example.Services.EstadoMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/estado-mantenimiento")
public class EstadoMantenimientoController extends ControllerGeneric<EstadoMantenimiento, Long, EstadoMantenimientoRepository, EstadoMantenimientoService> {

    @Autowired
    public EstadoMantenimientoController(EstadoMantenimientoService estadoMantenimientoService) {
        super(estadoMantenimientoService);
    }

    // Buscar por estado actual del mantenimiento
    @GetMapping("/estado/{estadoActual}")
    public ResponseEntity<List<EstadoMantenimiento>> buscarPorEstadoActual(@PathVariable String estadoActual) {
        try {
            List<EstadoMantenimiento> estados = service.buscarPorEstadoActual(estadoActual);
            return ResponseEntity.ok(estados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar estados de mantenimiento con ciclos mayores a un valor dado
    @GetMapping("/ciclos/mayores-a/{ciclos}")
    public ResponseEntity<List<EstadoMantenimiento>> buscarPorCiclosMayoresA(@PathVariable int ciclos) {
        try {
            List<EstadoMantenimiento> estados = service.buscarPorCiclosMayoresA(ciclos);
            return ResponseEntity.ok(estados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar estados de mantenimiento con horas de vuelo mayores a un valor dado
    @GetMapping("/horas-vuelo/mayores-a/{horasVuelo}")
    public ResponseEntity<List<EstadoMantenimiento>> buscarPorHorasVueloMayoresA(@PathVariable Double horasVuelo) {
        try {
            List<EstadoMantenimiento> estados = service.buscarPorHorasVueloMayoresA(horasVuelo);
            return ResponseEntity.ok(estados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar estados de mantenimiento con última inspección antes de una fecha dada
    @GetMapping("/ultimo-mantenimiento/antes-de")
    public ResponseEntity<List<EstadoMantenimiento>> buscarPorFechaUltimoMantenimientoAntesDe(@RequestParam Date fecha) {
        try {
            List<EstadoMantenimiento> estados = service.buscarPorFechaUltimoMantenimientoAntesDe(fecha);
            return ResponseEntity.ok(estados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar estados de mantenimiento con próxima inspección después de una fecha dada
    @GetMapping("/proxima-inspeccion/despues-de")
    public ResponseEntity<List<EstadoMantenimiento>> buscarPorProximaInspeccionDespuesDe(@RequestParam Date fecha) {
        try {
            List<EstadoMantenimiento> estados = service.buscarPorProximaInspeccionDespuesDe(fecha);
            return ResponseEntity.ok(estados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar estados de mantenimiento con próxima inspección antes de una fecha específica
    @GetMapping("/proxima-inspeccion/antes-de")
    public ResponseEntity<List<EstadoMantenimiento>> buscarPorProximaInspeccionAntesDe(@RequestParam Date fecha) {
        try {
            List<EstadoMantenimiento> estados = service.buscarPorProximaInspeccionAntesDe(fecha);
            return ResponseEntity.ok(estados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar estados de mantenimiento donde la última inspección fue antes de una fecha y la próxima inspección después de otra
    @GetMapping("/mantenimiento/entre")
    public ResponseEntity<List<EstadoMantenimiento>> buscarPorUltimoMantenimientoAntesDeYProximaInspeccionDespuesDe(
            @RequestParam Date fechaUltimo,
            @RequestParam Date fechaProxima) {
        try {
            List<EstadoMantenimiento> estados = service.buscarPorUltimoMantenimientoAntesDeYProximaInspeccionDespuesDe(fechaUltimo, fechaProxima);
            return ResponseEntity.ok(estados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
