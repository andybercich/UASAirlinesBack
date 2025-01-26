package org.example.Services;

import org.example.Entities.Piloto;
import org.example.Repositories.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PilotoService extends ServiceGeneric<Piloto,Long, PilotoRepository>{

    @Autowired
    public PilotoService(PilotoRepository pilotoRepository) {
        this.repository = pilotoRepository;
    }

    public List<Piloto> buscarPilotoPorLicencia(String tipoLicencia) throws Exception {
        try {
            return repository.findByTipoLicencia(tipoLicencia);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Piloto> buscarPilotoConMasDeCiertasHorasDeVuelo(int horas) throws Exception {
        try {
            return repository.findByHorasVueloGreaterThan(horas);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Optional<Piloto> buscarPilotoPorNumeroDeLicencia(int numLicencia) throws Exception {
        try {
            return repository.findByNumLicencia(numLicencia);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Piloto> buscarPilotoConInspeccionReciente(Date fecha) throws Exception {
        try {
            return repository.findByFechaUltimaInspeccionAfter(fecha);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Piloto> buscarPilotoConPruebasProximas(Date inicio, Date fin) throws Exception {
        try {
            return repository.findByProximaPruebaBetween(inicio, fin);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public long contarPilotosPorLicencia(String tipoLicencia) throws Exception {
        try {
            return repository.countByTipoLicencia(tipoLicencia);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Piloto> buscarPilotosConLicenciaPorVencer(Date fechaLimite) throws Exception {
        try {
            return repository.findPilotosConLicenciaPorVencer(fechaLimite);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}