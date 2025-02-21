package org.example.Repositories;

import org.example.Entities.Supervisor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupervisorRepository extends RepositorioGenerico<Supervisor,Long>{
    // Buscar por nombre de usuario
    Supervisor findByUsuario(String usuario);


    // Buscar supervisores por nombre de usuario y contraseña (para autenticación)
    Supervisor findByUsuarioAndPassword(String usuario, String password);

    // Verificar si existe un usuario específico en la base de datos
    boolean existsByUsuario(String usuario);
}
