package org.example.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aeropuerto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aeropuerto extends Base {

    private String nombre;

    private double distanciaPistaKm;

    private Ciudad ciudad;

}