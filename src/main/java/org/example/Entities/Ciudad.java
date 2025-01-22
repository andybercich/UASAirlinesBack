package org.example.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ciudad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad extends Base {

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_pais")
    private Pais pais;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Aeropuerto> aeropuertos = new HashSet<>();

}