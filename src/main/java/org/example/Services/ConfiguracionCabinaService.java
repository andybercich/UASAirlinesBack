package org.example.Services;

import org.example.Entities.ConfiguracionCabina;
import org.example.Entities.enums.Clase;
import org.example.Repositories.ConfiguracionCabinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguracionCabinaService extends ServiceGeneric<ConfiguracionCabina, Long, ConfiguracionCabinaRepository> {

    @Autowired
    public ConfiguracionCabinaService(ConfiguracionCabinaRepository configuracionCabinaRepository) {
        this.repository = configuracionCabinaRepository;
    }

    // Buscar configuraciones por una clase disponible
    public List<ConfiguracionCabina> buscarPorClaseDisponible(Clase clase) throws Exception {
        try {
            return repository.findByClasesDisponiblesContaining(clase);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}