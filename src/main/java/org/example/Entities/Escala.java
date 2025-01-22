package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.ZonedDateTime;

@Entity
public class Escala extends Base {

    private ZonedDateTime llegada;

    private ZonedDateTime salida;

    @ManyToOne
    @JoinColumn(name = "vuelo_id", nullable = false)
    private Vuelo vuelo;


}
