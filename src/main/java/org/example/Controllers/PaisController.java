package org.example.Controllers;

import org.example.Entities.Pais;
import org.example.Entities.enums.Continente;
import org.example.Repositories.PaisRepository;
import org.example.Services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/pais")
public class PaisController extends ControllerGeneric<Pais, Long, PaisRepository, PaisService> {

    @Autowired
    public PaisController(PaisService paisService) {
        super(paisService);
    }

    @GetMapping("/continente/{continente}")
    public ResponseEntity<List<Pais>> findByContinente(@PathVariable Continente continente) {
        try {
            return ResponseEntity.ok(service.findByContinente(continente));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

