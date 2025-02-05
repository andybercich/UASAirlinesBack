package org.example.Controllers;

import org.example.DTO.PasajeTagDTO;
import org.example.DTO.VueloTagDTO;
import org.example.Entities.Pasaje;
import org.example.Repositories.PasajeRepository;
import org.example.Services.PasajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pasaje")
public class PasajeController extends ControllerGeneric<Pasaje, Long, PasajeRepository, PasajeService> {

    @Autowired
    public PasajeController(PasajeService pasajeService) {
        super(pasajeService);
    }

    @GetMapping("/DTO")
    public ResponseEntity<List<PasajeTagDTO>> findAllVueloTagDTO() {
        try {

            return ResponseEntity.ok(service.getAllPasajeDTO());

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/vuelo/{id}")
    public ResponseEntity<List<PasajeTagDTO>> findPasajeByVueloId(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(service.getAllPasajeDTOByIdVuelo(id));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<PasajeTagDTO>> findPasajesByClienteId(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(service.getAllPasajeDTOByClienteID(id));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/vuelo/{id}/false")
    public ResponseEntity<List<PasajeTagDTO>> getAllPasajeDTOByIDVueloAndVendidoFalse(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(service.getAllPasajeDTOByIDVueloAndVendidoFalse(id));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }




}
