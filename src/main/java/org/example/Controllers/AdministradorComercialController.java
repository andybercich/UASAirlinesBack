package org.example.Controllers;

import org.example.Entities.AdministradorComercial;
import org.example.Repositories.AdministradorComercialRepository;
import org.example.Services.AdministradorComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admincomercial")
public class AdministradorComercialController extends ControllerGeneric<AdministradorComercial,Long, AdministradorComercialRepository, AdministradorComercialService> {

    @Autowired
    public AdministradorComercialController(AdministradorComercialService service) {
        super(service);
    }

    @GetMapping("/buscar-user")
    public ResponseEntity<AdministradorComercial> buscarPorUserYPass(
            @RequestParam String user,
            @RequestParam String password) {
        try {
            Optional<AdministradorComercial> admin = service.buscarPorUserYPass(user, password);
            if (admin.isPresent()) { // para ver si el optional tiene un valor
                return ResponseEntity.ok(admin.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/usuarios-distintos")
    public ResponseEntity<List<String>> obtenerUsuariosDistintos() {
        try {
            List<String> usuarios = service.buscarPorNombresDistintitos();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/incorporacion")
    public ResponseEntity<List<AdministradorComercial>> buscarPorFechaIncorporacion(@RequestParam LocalDate fecha) {
        try {
            List<AdministradorComercial> usuarios = service.buscarPorFechaIncorporacion(fecha);
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/nombre-apellido")
    public ResponseEntity<List<AdministradorComercial>> buscarPorNombreyApellido(@RequestParam String nombre, @RequestParam String apellido) {
        try {
            List<AdministradorComercial> usuarios = service.buscarPorNombreyApellido(nombre,apellido);
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}