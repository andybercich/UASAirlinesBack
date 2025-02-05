package org.example.Repositories;

import org.example.Entities.AdministradorComercial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdministradorComercialRepository extends RepositorioGenerico<AdministradorComercial,Long>{

    //Buscar por usuario y contraseña (para autenticación)
    Optional<AdministradorComercial> findByUserAndPassword(String user, String password);

    //Buscar administradores comerciales con nombres de usuario únicos (distintos) para que no haya erpetidos
    @Query("SELECT DISTINCT a.user FROM AdministradorComercial a")
    List<String> findDistinctUsers();

    //Buscar por fecha de incorporación
    List<AdministradorComercial> findByIncorporacionAfter(LocalDate fecha);

    //Buscar por nombre completo (nombre y apellido)
    List<AdministradorComercial> findByNombreAndApellido(String nombre, String apellido);

}