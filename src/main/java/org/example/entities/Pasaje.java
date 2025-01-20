package org.example.Entities;

import jakarta.persistence.*;

@Entity
public class Pasaje extends org.example.entities.Base {

    private String asiento;

    private int descuento;

    public double precio;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private Clase clase;

    @ManyToOne
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo;

}
