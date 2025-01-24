package org.example.Repositories;

import org.example.Entities.Cliente;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientesRepository extends RepositorioGenerico<Cliente, Long>{

    Optional<Cliente> findByDni(Long dni);

}
