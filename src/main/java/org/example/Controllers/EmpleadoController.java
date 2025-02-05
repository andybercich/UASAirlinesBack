package org.example.Controllers;

import org.example.Entities.Empleado;
import org.example.Entities.enums.EstadoCivil;
import org.example.Repositories.EmpleadoRepository;
import org.example.Services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController extends ControllerGeneric<Empleado,Long, EmpleadoRepository, EmpleadoService>{

    @Autowired
    public EmpleadoController(EmpleadoService service) {
        super(service);
    }

    @GetMapping("/incorporaciones")
    public ResponseEntity<List<Empleado>> porRangoFechaIncorporacion(@RequestParam LocalDate inicio, @RequestParam LocalDate fin) throws Exception{
        try {
            List<Empleado> empleados = service.porRangoFechaIncorporacion(inicio,fin);
            return ResponseEntity.ok(empleados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/vencimiento-contrato")
    public ResponseEntity<List<Empleado>> porContratoProntoVencerAntes(@RequestParam LocalDate fecha) throws Exception{
        try {
            List<Empleado> empleados = service.porContratoProntoVencerAntes(fecha);
            return ResponseEntity.ok(empleados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/estado-civil")
    public ResponseEntity<List<Empleado>> porEstadoCivil(@RequestParam EstadoCivil estadoCivil) throws Exception{
        try {
            List<Empleado> empleados = service.porEstadoCivil(estadoCivil);
            return ResponseEntity.ok(empleados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}