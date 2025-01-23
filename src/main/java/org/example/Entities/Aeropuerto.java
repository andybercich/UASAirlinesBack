package org.example.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Aeropuerto extends Base {

    private String nombre;

    @Column(name = "distancia_pista_km")
    private double distanciaPistaKm;

    @ManyToOne
    @JoinColumn(name = "fk_ciudad")
    private Ciudad ciudad;

    @OneToMany(mappedBy = "aeropuerto", orphanRemoval = true)
    private Set<Escala> escalas = new HashSet<>();

    @OneToMany(mappedBy = "ubicacionActual", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Avion> aviones = new HashSet<>();

    @OneToMany(mappedBy = "origen")
    private Set<Vuelo> salidas = new HashSet<>();

    @OneToMany(mappedBy = "destino")
    private Set<Vuelo> llegadas = new HashSet<>();


}