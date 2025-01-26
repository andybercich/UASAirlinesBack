package org.example.Services;

import org.example.Entities.AdministradorComercial;
import org.example.Repositories.AdministradorComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorComercialService extends ServiceGeneric<AdministradorComercial, Long, AdministradorComercialRepository> {

    @Autowired
    public AdministradorComercialService(AdministradorComercialRepository adminRepository) {
        this.repository = adminRepository;
    }

    public Optional<AdministradorComercial> buscarPorUserYPass(String user, String password) throws Exception {
        try {
            return repository.findByUserAndPassword(user, password);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<String> buscarPorNombresDistintitos() throws Exception {
        try {
            return repository.findDistinctUsers();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}