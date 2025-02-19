package org.example.Controllers;

import org.example.Entities.ConfiguracionCabina;
import org.example.Entities.enums.Clase;
import org.example.Repositories.ConfiguracionCabinaRepository;
import org.example.Services.ConfiguracionCabinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuracion-cabina")
public class ConfiguracionCabinaController extends ControllerGeneric<ConfiguracionCabina, Long, ConfiguracionCabinaRepository, ConfiguracionCabinaService> {

    @Autowired
    public ConfiguracionCabinaController(ConfiguracionCabinaService configuracionCabinaService) {
        super(configuracionCabinaService);
    }

    // Buscar configuraciones por una clase disponible
    @GetMapping("/clase-disponible")
        public ResponseEntity<List<ConfiguracionCabina>> buscarPorClaseDisponible(@RequestParam Clase clase) {
        try {
            List<ConfiguracionCabina> configuraciones = service.buscarPorClaseDisponible(clase);
            return ResponseEntity.ok(configuraciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
