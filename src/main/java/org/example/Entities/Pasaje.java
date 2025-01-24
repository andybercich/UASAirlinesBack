package org.example.Entities;

import jakarta.persistence.*;
import org.example.Entities.enums.Clase;

@Entity
public class Pasaje extends Base {

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

    private boolean vendido;

}
