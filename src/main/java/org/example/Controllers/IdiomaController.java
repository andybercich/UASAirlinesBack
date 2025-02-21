package org.example.Controllers;

import org.example.Entities.Idioma;
import org.example.Repositories.IdiomaRepository;
import org.example.Services.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;

public class IdiomaController extends ControllerGeneric<Idioma,Long, IdiomaRepository, IdiomaService> {

    @Autowired
    public IdiomaController(IdiomaService idiomaService) {
        super(idiomaService);
    }
}
