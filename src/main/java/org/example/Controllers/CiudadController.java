package org.example.Controllers;

import org.example.Entities.Ciudad;
import org.example.Entities.Cliente;
import org.example.Repositories.CiudadRepository;
import org.example.Services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ciudad")
public class CiudadController extends ControllerGeneric<Ciudad, Long, CiudadRepository, CiudadService>{


    @Autowired
    public CiudadController(CiudadService ciudadService) {
        super(ciudadService);
    }


    @GetMapping("pais/{id}")
    public ResponseEntity<List<Ciudad>> findCiudadByPaisId(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(service.findByPaisId(id));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }



}
