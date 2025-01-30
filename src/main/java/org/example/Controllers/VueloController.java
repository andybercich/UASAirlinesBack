package org.example.Controllers;

import org.example.DTO.VueloTagDTO;
import org.example.Entities.Vuelo;
import org.example.Entities.enums.TipoOperacion;
import org.example.Repositories.VueloRepository;
import org.example.Services.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/vuelo")
public class VueloController extends ControllerGeneric<Vuelo, Long, VueloRepository, VueloService>{

    @Autowired
    public VueloController(VueloService vueloService) {
        super(vueloService);
    }

    @GetMapping("/DTO")
    public ResponseEntity<List<VueloTagDTO>> findAllVueloTagDTO() {
        try {
            return ResponseEntity.ok(service.findVueloDTOAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/DTO/{id}")
    public ResponseEntity<VueloTagDTO> findVueloDTOByID(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findVueloDTOById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/origen/{idOrigen}/destino/{idDestino}")
    public ResponseEntity<List<VueloTagDTO>> getAllVuelosByOrigenAndDestino(@PathVariable Long idOrigen,
                                                                      @PathVariable Long idDestino) {
        try {
            return ResponseEntity.ok(service.findByOrigenIdAndDestinoId(idOrigen, idDestino));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/rangoFechas")
    public ResponseEntity<List<VueloTagDTO>> findByFechaHoraSalidaBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime endDate) {
        try {
            return ResponseEntity.ok(service.findByFechaHoraSalidaBetween(startDate, endDate));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/sinEscala")
    public ResponseEntity<List<VueloTagDTO>> findAllSinEscala() {
        try {
            return ResponseEntity.ok(service.findByConEscalaFalse());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/conEscala")
    public ResponseEntity<List<VueloTagDTO>> findAllConEscala() {
        try {
            return ResponseEntity.ok(service.findByConEscalaTrue());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/operacion/{operacion}")
    public ResponseEntity<List<VueloTagDTO>> findByTipoOperacion(@PathVariable String operacion) {
        try {
            TipoOperacion tipoOperacion = TipoOperacion.valueOf(operacion.toUpperCase());
            return ResponseEntity.ok(service.findByTipoOperacion(tipoOperacion));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/destino/{id}")
    public ResponseEntity<List<VueloTagDTO>> findByDestinoId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findByDestinoId(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/origen/{id}")
    public ResponseEntity<List<VueloTagDTO>> findByOrigenId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findByOrigenId(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/avion/{id}")
    public ResponseEntity<List<VueloTagDTO>> findByAvionId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findByAvionId(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
