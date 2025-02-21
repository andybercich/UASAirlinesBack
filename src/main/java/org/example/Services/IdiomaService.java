package org.example.Services;

import org.example.Entities.Idioma;
import org.example.Repositories.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdiomaService extends ServiceGeneric<Idioma, Long, IdiomaRepository>{
    @Autowired
    public IdiomaService(IdiomaRepository repository){this.repository = repository;}
}
