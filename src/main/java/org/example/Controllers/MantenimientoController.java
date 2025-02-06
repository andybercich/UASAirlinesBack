package org.example.Controllers;

import org.example.Entities.EstadoMantenimiento;
import org.example.Entities.Mantenimiento;
import org.example.Repositories.MantenimientoRepository;
import org.example.Services.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mantenimientos")
public class MantenimientoController extends ControllerGeneric<Mantenimiento, Long, MantenimientoRepository, MantenimientoService> {

    @Autowired
    public MantenimientoController(MantenimientoService mantenimientoService) {
        super(mantenimientoService);
    }

    // Buscar mantenimientos por estado
    @GetMapping("/estado")
    public ResponseEntity<List<Mantenimiento>> buscarPorEstado(@RequestParam EstadoMantenimiento estado) {
        try {
            List<Mantenimiento> mantenimientos = service.buscarPorEstado(estado);
            return ResponseEntity.ok(mantenimientos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    // Buscar mantenimientos programados
    @GetMapping("/programados")
    public ResponseEntity<List<Mantenimiento>> buscarProgramados() {
        try {
            List<Mantenimiento> mantenimientos = service.buscarProgramados();
            return ResponseEntity.ok(mantenimientos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}