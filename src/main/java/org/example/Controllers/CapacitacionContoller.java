package org.example.Controllers;

import org.example.Entities.Capacitacion;
import org.example.Repositories.CapacitacionRepository;
import org.example.Services.CapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/capacitaciones")
public class CapacitacionContoller extends ControllerGeneric<Capacitacion,Long, CapacitacionRepository, CapacitacionService> {

    @Autowired
    public CapacitacionContoller(CapacitacionService service) {
        super(service);
    }

    @GetMapping("/nombre")
    public ResponseEntity<List<Capacitacion>> buscarCapacitacionPorNombre(@RequestParam String nombre) throws Exception{
        try {
            List<Capacitacion> capacitaciones = service.buscarCapacitacionPorNombre(nombre);
            return ResponseEntity.ok(capacitaciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/rango-fechas")
    public ResponseEntity<List<Capacitacion>> buscarCapacitacionPorRangoDeFechas(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFinal) throws Exception{
        try {
            List<Capacitacion> capacitaciones = service.buscarCapacitacionPorRangoDeFechas(fechaInicio, fechaFinal);
            return ResponseEntity.ok(capacitaciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/empleado")
    public ResponseEntity<List<Capacitacion>> buscarCapacitacionPorEmpleado(@RequestParam Long idEmpleado) throws Exception{
        try {
            List<Capacitacion> capacitacionEmpleado = service.buscarCapacitacionPorEmpleado(idEmpleado);
            return ResponseEntity.ok(capacitacionEmpleado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/fecha-inicio")
    public ResponseEntity<List<Capacitacion>> buscarPorFechaInicioDespues(@RequestParam LocalDate fechaInicio) throws Exception{
        try {
            List<Capacitacion> capacitacionEmpleado = service.buscarPorFechaInicioDespues(fechaInicio);
            return ResponseEntity.ok(capacitacionEmpleado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}