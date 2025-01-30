package org.example.Entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Cliente extends Persona{


    private double kmAcumulados;

}
