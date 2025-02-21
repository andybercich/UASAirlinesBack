package org.example.Controllers;

import org.example.Entities.Tecnico;
import org.example.Repositories.TecnicoRepository;
import org.example.Services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;

public class TecnicoController extends ControllerGeneric<Tecnico, Long, TecnicoRepository, TecnicoService>{
    @Autowired
    public TecnicoController(TecnicoService tecnicoService) {
        super(tecnicoService);
    }
}
