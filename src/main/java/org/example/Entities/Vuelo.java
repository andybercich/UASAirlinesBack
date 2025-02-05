package org.example.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.Entities.enums.TipoOperacion;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Vuelo extends Base {

    @OneToOne
    @JoinColumn(name="fk_avion")
    private Avion avion;

    private double distanciaRecorrerKm;

    private boolean conEscala;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Escala> escalas = new HashSet<>();

    private ZonedDateTime fechaHoraLlegada;

    private ZonedDateTime fechaHoraSalida;

    @ManyToOne
    @NotNull(message = "El vuelo tiene que tener origen")
    private Aeropuerto origen;

    @ManyToOne
    @NotNull(message = "El vuelo tiene que tener destino")
    private Aeropuerto destino;

    private double horasVuelo;


    @Enumerated(EnumType.STRING)
    private TipoOperacion tipoOperacion;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pasaje> pasajes = new ArrayList<>();

}
