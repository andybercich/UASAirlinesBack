package org.example.Entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Cliente extends Persona{

    private int dni;

    private double kmAcumulados;

}
