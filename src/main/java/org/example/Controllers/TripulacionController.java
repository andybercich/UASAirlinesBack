package org.example.Controllers;

import org.example.Entities.Piloto;
import org.example.Entities.Tripulacion;
import org.example.Entities.enums.EstadoTripulacion;
import org.example.Repositories.TripulacionRepository;
import org.example.Services.PilotoService;
import org.example.Services.TripulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tripulacion")
public class TripulacionController extends ControllerGeneric<Tripulacion,Long, TripulacionRepository, TripulacionService>{

    @Autowired
    public TripulacionController(TripulacionService service) {
        super(service);
    }
    @Autowired
    private PilotoService pilotoService;

    @GetMapping("/estado")
    public ResponseEntity<List<Tripulacion>> buscarTripulacionEstado(@RequestParam EstadoTripulacion estado) throws Exception{
        try {
            List<Tripulacion> tripulacion = service.buscarTripulacionEstado(estado);
            return ResponseEntity.ok(tripulacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/capacitacion")
    public ResponseEntity<List<Tripulacion>> buscarTripulacionPorCapacitacionAntesDe(@RequestParam LocalDate fecha) throws Exception{
        try {
            List<Tripulacion> tripulacion = service.buscarTripulacionPorCapacitacionAntesDe(fecha);
            return ResponseEntity.ok(tripulacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/capitan")
    public ResponseEntity<List<Tripulacion>> buscarTripulacionPorCapitan(@RequestParam Long capitanId) throws Exception{
        try {
            Piloto capitan = pilotoService.findById(capitanId);
            List<Tripulacion> tripulacion = service.buscarTripulacionPorCapitan(capitan);
            return ResponseEntity.ok(tripulacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/capitan-estado")
    public ResponseEntity<List<Tripulacion>> buscarPorCapitanyEstadoTripulacion(@RequestParam Piloto capitan, @RequestParam EstadoTripulacion estadoTripulacion) throws Exception{
        try {
            Piloto capitans = pilotoService.findById(capitan.getId());
            List<Tripulacion> tripulacion = service.buscarPorCapitanyEstadoTripulacion(capitans,estadoTripulacion);
            return ResponseEntity.ok(tripulacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/copiloto")
    public ResponseEntity<List<Tripulacion>> buscarTripulacionPorCopiloto(@RequestParam Piloto copiloto) throws Exception{
        try {
            Piloto copilotos = pilotoService.findById(copiloto.getId());
            List<Tripulacion> tripulacion = service.buscarTripulacionPorCopiloto(copilotos);
            return ResponseEntity.ok(tripulacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }





}