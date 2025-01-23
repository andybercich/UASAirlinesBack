package org.example.Services;

import org.example.Entities.AdministradorComercial;
import org.example.Repositories.AdministradorComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorComercialService extends ServiceGeneric<AdministradorComercial, Long, AdministradorComercialRepository> {

    @Autowired
    public AdministradorComercialService(AdministradorComercialRepository adminRepository) {
        this.repository = adminRepository;
    }

}