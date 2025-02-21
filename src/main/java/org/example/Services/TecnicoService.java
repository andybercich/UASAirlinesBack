package org.example.Services;

import org.example.Entities.Tecnico;
import org.example.Entities.Mantenimiento;
import org.example.Repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TecnicoService extends ServiceGeneric<Tecnico,Long, TecnicoRepository> {
    @Autowired
    public TecnicoService(TecnicoRepository repository){this.repository=repository;}

    // Buscar técnicos por tipo de licencia
    public List<Tecnico> buscarPorTipoLicencia(String tipoLicencia) {
        return repository.findByTipoLicencia(tipoLicencia);
    }

    // Buscar técnicos cuya licencia vence antes de una fecha
    public List<Tecnico> buscarPorLicenciaVencidaAntesDe(Date fecha) {
        return repository.findByVencimientoLicenciaBefore(fecha);
    }

    // Buscar técnicos cuya licencia vence después de una fecha
    public List<Tecnico> buscarPorLicenciaVencidaDespuesDe(Date fecha) {
        return repository.findByVencimientoLicenciaAfter(fecha);
    }

    // Buscar técnicos asociados a un mantenimiento específico
    public List<Tecnico> buscarPorMantenimiento(Mantenimiento mantenimiento) {
        return repository.findByMantenimientos(mantenimiento);
    }

    // Contar técnicos con licencia vencida
    public long contarTecnicosConLicenciaVencida(Date fecha) {
        return repository.countByVencimientoLicenciaBefore(fecha);
    }


    // Buscar técnicos por nombre (sin distinguir mayúsculas/minúsculas)
    public List<Tecnico> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }


}
