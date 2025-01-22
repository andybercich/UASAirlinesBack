package org.example.Entities;

import jakarta.persistence.*;
import org.example.Entities.enums.PropositoVuelo;
import org.example.Entities.enums.TipoOperacion;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vuelo extends Base {

    //DUDAS
    @OneToOne
    @JoinColumn(name="fk_avion")
    private Avion avion;

    //Falta la relacion con Llegada con aeropuerto

    private double distanciaRecorrerKm;

    private boolean conEscala;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Escala> escalas = new HashSet<>();

    private ZonedDateTime fechaHoraLlegada;

    private ZonedDateTime fechaHoraSalida;

    //Falta relacion con Origen Aeropuerto

    private double horasVuelo;

    @Enumerated(EnumType.STRING)
    private PropositoVuelo propositoVuelo;

    @Enumerated(EnumType.STRING)
    private TipoOperacion tipoOperacion;

}
