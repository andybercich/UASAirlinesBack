package org.example.Controllers;

import org.example.Entities.PersonalCabina;
import org.example.Entities.enums.RolCabina;
import org.example.Repositories.PersonalCabinaRepository;
import org.example.Services.PersonalCabinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/personalcabina")
public class PersonalCabinaController extends ControllerGeneric<PersonalCabina,Long, PersonalCabinaRepository, PersonalCabinaService>{

    @Autowired
    public PersonalCabinaController(PersonalCabinaService service) {
        super(service);
    }

    @GetMapping("/idioma")
    public ResponseEntity<List<PersonalCabina>> buscarPersonalPorIdioma(@RequestParam String idioma) throws Exception{
        try {
            List<PersonalCabina> personal = service.buscarPersonalPorIdioma(idioma);
            return ResponseEntity.ok(personal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/rol")
    public ResponseEntity<List<PersonalCabina>> buscarPersonalPorRolEspecifico(@RequestParam RolCabina rolCabina) throws Exception{
        try {
            List<PersonalCabina> personal = service.buscarPersonalPorRolEspecifico(rolCabina);
            return ResponseEntity.ok(personal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/tripulacion")
    public ResponseEntity<List<PersonalCabina>> buscarPersonalPorTripulacion(@RequestParam Long tripulacionId) throws Exception{
        try {
            List<PersonalCabina> personal = service.buscarPersonalPorTripulacion(tripulacionId);
            return ResponseEntity.ok(personal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/tripulacion-rol")
    public ResponseEntity<List<PersonalCabina>> buscarPersonalPorTripulacionyRol(@RequestParam Long tripulacionId, @RequestParam RolCabina rol) throws Exception{
        try {
            List<PersonalCabina> personal = service.buscarPersonalPorTripulacionyRol(tripulacionId,rol);
            return ResponseEntity.ok(personal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/tripulacion-idioma")
    public ResponseEntity<List<PersonalCabina>> buscarPersonalPorTripulacionyIdioma(@RequestParam Long tripulacionId, @RequestParam String idioma) throws Exception{
        try {
            List<PersonalCabina> personal = service.buscarPersonalPorTripulacionyIdioma(tripulacionId,idioma);
            return ResponseEntity.ok(personal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/rol-idioma")
    public ResponseEntity<List<PersonalCabina>> buscarPersonalPorRolyIdioma(@RequestParam RolCabina rol, @RequestParam String idioma) throws Exception{
        try {
            List<PersonalCabina> personal = service.buscarPersonalPorRolyIdioma(rol,idioma);
            return ResponseEntity.ok(personal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}