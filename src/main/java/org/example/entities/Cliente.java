package org.example.Entities;

import jakarta.persistence.Entity;

@Entity
//Hay que hacer que herede de persona
public class Cliente {

    private Long dni;

    private double kmAcumulados;

}
