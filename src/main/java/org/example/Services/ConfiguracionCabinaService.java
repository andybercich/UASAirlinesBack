package org.example.Services;

import org.example.Entities.ConfiguracionCabina;
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
    public List<ConfiguracionCabina> buscarPorClaseDisponible(String clase) throws Exception {
        try {
            return repository.findByClasesDisponiblesContaining(clase);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Buscar configuraciones por sistema de entretenimiento
    public List<ConfiguracionCabina> buscarPorEntretenimiento(String entretenimiento) throws Exception {
        try {
            return repository.findByEntretenimiento(entretenimiento);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Buscar configuraciones por sistema de comunicación
    public List<ConfiguracionCabina> buscarPorSistemaComunicacion(String sistemaComunicacion) throws Exception {
        try {
            return repository.findBySistemasComunicacion(sistemaComunicacion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Buscar configuraciones por modificaciones realizadas
    public List<ConfiguracionCabina> buscarPorModificacion(String modificacion) throws Exception {
        try {
            return repository.findByModificacionesRealizadasContaining(modificacion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Buscar configuraciones por sistema de seguridad
    public List<ConfiguracionCabina> buscarPorSistemaSeguridad(String sistemaSeguridad) throws Exception {
        try {
            return repository.findBySistemaSeguridad(sistemaSeguridad);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}