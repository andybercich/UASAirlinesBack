package org.example.Services;

import org.example.Entities.Cliente;
import org.example.Repositories.ClientesRepository;
import org.example.Repositories.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService extends ServiceGeneric<Cliente, Long, ClientesRepository>{

    public ClienteService(ClientesRepository clientesRepository) {
        this.repository = clientesRepository;
    }

    public Cliente getClienteByDNI(Long dni) throws Exception {
        try {

            Cliente cliente= repository.findByDni(dni);


            return cliente;



        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



}
