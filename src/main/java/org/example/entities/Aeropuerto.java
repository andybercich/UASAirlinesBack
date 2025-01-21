package org.example.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aeropuerto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aeropuerto extends org.example.Entities.Base {

    private String nombre;

    @Column(name = "distancia_pista_km")
    private double distanciaPistaKm;

    @ManyToOne
    @JoinColumn(name = "fk_ciudad")
    private org.example.Entities.Ciudad ciudad;

}