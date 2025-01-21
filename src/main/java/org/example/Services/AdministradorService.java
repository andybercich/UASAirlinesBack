package org.example.Services;


import org.example.Entities.AdministradorComercial;
import org.example.Repositories.AdministradorRepo;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService extends ServiceGeneric<AdministradorComercial, Long, AdministradorRepo> {

    public AdministradorService(AdministradorRepo adminRepository) {
        this.repository = adminRepository;
    }

}
