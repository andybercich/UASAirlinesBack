package org.example.Controllers;


import org.example.Entities.Supervisor;
import org.example.Repositories.SupervisorRepository;
import org.example.Services.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supervisores")
public class SupervisorController extends ControllerGeneric<Supervisor, Long, SupervisorRepository, SupervisorService> {

    @Autowired
    public SupervisorController(SupervisorService supervisorService) {
        super(supervisorService);
    }

    // Buscar supervisor por nombre de usuario
    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<Supervisor> buscarPorUsuario(@PathVariable String usuario) {
        try {
            Supervisor supervisor = service.buscarPorUsuario(usuario);
            if (supervisor != null) {
                return ResponseEntity.ok(supervisor);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Autenticar supervisor por usuario y contraseña
    @PostMapping("/autenticar")
    public ResponseEntity<Supervisor> autenticarSupervisor(@RequestParam String usuario, @RequestParam String password) {
        try {
            Supervisor supervisor = service.autenticarSupervisor(usuario, password);
            if (supervisor != null) {
                return ResponseEntity.ok(supervisor);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }




    @GetMapping("/contar")
    public ResponseEntity<Long> contarSupervisores() {
        try {
            long cantidad = service.contarSupervisores();
            return ResponseEntity.ok(cantidad);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/existe/{usuario}")
    public ResponseEntity<Boolean> existeUsuario(@PathVariable String usuario) {
        try {
            boolean existe = service.existeUsuario(usuario);
            return ResponseEntity.ok(existe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}

