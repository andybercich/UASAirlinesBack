package org.example.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.enums.Continente;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Pais extends Base {

    private String nombre;

    @Enumerated(value = EnumType.STRING)
    private Continente continente;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ciudad> ciudades = new HashSet<>();

}