package org.example.Controllers;

import org.example.Entities.ConfiguracionCabina;
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
    public ResponseEntity<List<ConfiguracionCabina>> buscarPorClaseDisponible(@RequestParam String clase) {
        try {
            List<ConfiguracionCabina> configuraciones = service.buscarPorClaseDisponible(clase);
            return ResponseEntity.ok(configuraciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar configuraciones por sistema de entretenimiento
    @GetMapping("/entretenimiento")
    public ResponseEntity<List<ConfiguracionCabina>> buscarPorEntretenimiento(@RequestParam String entretenimiento) {
        try {
            List<ConfiguracionCabina> configuraciones = service.buscarPorEntretenimiento(entretenimiento);
            return ResponseEntity.ok(configuraciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar configuraciones por sistema de comunicación
    @GetMapping("/sistema-comunicacion")
    public ResponseEntity<List<ConfiguracionCabina>> buscarPorSistemaComunicacion(@RequestParam String sistemaComunicacion) {
        try {
            List<ConfiguracionCabina> configuraciones = service.buscarPorSistemaComunicacion(sistemaComunicacion);
            return ResponseEntity.ok(configuraciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar configuraciones por modificaciones realizadas
    @GetMapping("/modificaciones")
    public ResponseEntity<List<ConfiguracionCabina>> buscarPorModificacion(@RequestParam String modificacion) {
        try {
            List<ConfiguracionCabina> configuraciones = service.buscarPorModificacion(modificacion);
            return ResponseEntity.ok(configuraciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Buscar configuraciones por sistema de seguridad
    @GetMapping("/sistema-seguridad")
    public ResponseEntity<List<ConfiguracionCabina>> buscarPorSistemaSeguridad(@RequestParam String sistemaSeguridad) {
        try {
            List<ConfiguracionCabina> configuraciones = service.buscarPorSistemaSeguridad(sistemaSeguridad);
            return ResponseEntity.ok(configuraciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
