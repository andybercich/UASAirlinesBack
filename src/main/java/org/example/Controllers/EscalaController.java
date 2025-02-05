package org.example.Controllers;


import org.example.DTO.EscalaTagDTO;
import org.example.Entities.Escala;
import org.example.Repositories.EscalaRepository;
import org.example.Services.EscalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/escala")
public class EscalaController extends ControllerGeneric<Escala, Long, EscalaRepository, EscalaService> {

    @Autowired
    public EscalaController(EscalaService escalaService) {
        super(escalaService);
    }

    @GetMapping("/vuelo/{id}")
    public ResponseEntity<List<EscalaTagDTO>> findByVueloId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findByVueloId(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/aeropuerto/{id}")
    public ResponseEntity<List<EscalaTagDTO>> findByAeropuertoId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findByAeropuertoID(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/llegada/after/{fecha}")
    public ResponseEntity<List<EscalaTagDTO>> findByLlegadaAfter(@PathVariable ZonedDateTime fecha) {
        try {
            return ResponseEntity.ok(service.findByLlegadaAfter(fecha));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/salida/before/{fecha}")
    public ResponseEntity<List<EscalaTagDTO>> findBySalidaBefore(@PathVariable ZonedDateTime fecha) {
        try {
            return ResponseEntity.ok(service.findBySalidaBefore(fecha));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/rangoFechas")
    public ResponseEntity<List<EscalaTagDTO>> findByLlegadaBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime llegada,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime salida) {
        try {
            return ResponseEntity.ok(service.findByLlegadaBetween(llegada, salida));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
