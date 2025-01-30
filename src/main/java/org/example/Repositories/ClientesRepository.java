package org.example.Repositories;

import org.example.Entities.Cliente;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientesRepository extends RepositorioGenerico<Cliente, Long>{

    Cliente findByDni(Long dni);

}
