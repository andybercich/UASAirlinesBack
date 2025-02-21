package org.example.Services;

import org.example.Entities.Supervisor;
import org.example.Repositories.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupervisorService extends ServiceGeneric<Supervisor, Long, SupervisorRepository>{
    @Autowired
    public SupervisorService(SupervisorRepository supervisorRepository){this.repository = supervisorRepository;}

    public Supervisor buscarPorUsuario(String usuario) {
        return repository.findByUsuario(usuario);
    }



    public Supervisor autenticarSupervisor(String usuario, String password) {
        return repository.findByUsuarioAndPassword(usuario, password);
    }



    public long contarSupervisores() {
        return repository.count();
    }

    public boolean existeUsuario(String usuario) {
        return repository.existsByUsuario(usuario);
    }
}
