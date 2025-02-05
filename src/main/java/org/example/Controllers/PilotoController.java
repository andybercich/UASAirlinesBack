package org.example.Controllers;

import org.example.Entities.Piloto;
import org.example.Repositories.PilotoRepository;
import org.example.Services.PilotoService;
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
import java.util.Optional;

@RestController
@RequestMapping("/pilotos")
public class PilotoController extends ControllerGeneric<Piloto,Long, PilotoRepository, PilotoService>{

    @Autowired
    public PilotoController(PilotoService service) {
        super(service);
    }

    @GetMapping("/licencia")
    public ResponseEntity<List<Piloto>> buscarPilotoPorLicencia(@RequestParam String tipoLicencia) throws Exception{
        try {
            List<Piloto> pilotos = service.buscarPilotoPorLicencia(tipoLicencia);
            return ResponseEntity.ok(pilotos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/horas")
    public ResponseEntity<List<Piloto>> buscarPilotoConMasDeCiertasHorasDeVuelo(@RequestParam int horas) throws Exception{
        try {
            List<Piloto> pilotos = service.buscarPilotoConMasDeCiertasHorasDeVuelo(horas);
            return ResponseEntity.ok(pilotos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/num-licencia")
    public ResponseEntity<Piloto> buscarPilotoPorNumeroDeLicencia(@RequestParam int numLicencia) throws Exception{
        try {
            Optional<Piloto> piloto = service.buscarPilotoPorNumeroDeLicencia(numLicencia);
            if (piloto.isPresent()){
                return ResponseEntity.ok(piloto.get());
            }else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/inspeccion")
    public ResponseEntity<List<Piloto>> buscarPilotoConInspeccionReciente(@RequestParam LocalDate fecha) throws Exception{
        try {
            List<Piloto> piloto = service.buscarPilotoConInspeccionReciente(fecha);
            return ResponseEntity.ok(piloto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/pruebas")
    public ResponseEntity<List<Piloto>> buscarPilotoConPruebasProximas(@RequestParam LocalDate inicio,@RequestParam LocalDate fin) throws Exception{
        try {
            List<Piloto> piloto = service.buscarPilotoConPruebasProximas(inicio, fin);
            return ResponseEntity.ok(piloto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/contar")
    public ResponseEntity<Long> contarPilotosPorLicencia(@RequestParam String tipoLicencia) throws Exception{
        try {
            long countPiloto = service.contarPilotosPorLicencia(tipoLicencia);
            return ResponseEntity.ok(countPiloto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/licencia-horas-vuelo")
    public ResponseEntity<List<Piloto>> porHorasDeVueloYTipoLicencia(@RequestParam String tipoLicencia,@RequestParam int horas) throws Exception{
        try {
            List<Piloto> piloto = service.porHorasDeVueloYTipoLicencia(tipoLicencia, horas);
            return ResponseEntity.ok(piloto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



}