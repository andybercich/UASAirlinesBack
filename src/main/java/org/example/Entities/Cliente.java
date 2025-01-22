package org.example.Entities;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Persona{

    private Long dni;

    private double kmAcumulados;

}
