package org.example.Repositories;

import org.example.Entities.Pasaje;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasajeRepository extends RepositorioGenerico<Pasaje,Long>{

    List<Pasaje> findByVueloId(Long vueloId);

    List<Pasaje> findByClienteId(Long clienteId);

    List<Pasaje> findByVueloIdAndVendidoFalse(Long vueloId);

}
