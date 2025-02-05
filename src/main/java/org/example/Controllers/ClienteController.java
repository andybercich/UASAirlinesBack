package org.example.Controllers;

import org.example.DTO.PasajeTagDTO;
import org.example.Entities.Cliente;
import org.example.Repositories.ClientesRepository;
import org.example.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends ControllerGeneric<Cliente, Long, ClientesRepository, ClienteService>{


    @Autowired
    public ClienteController(ClienteService clienteService) {
        super(clienteService);
    }


    @GetMapping("/dni/{dni}")
    public ResponseEntity<Cliente> findPasajeByVueloId(@PathVariable Long dni) {
        try {

            return ResponseEntity.ok(service.getClienteByDNI(dni));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }




}
