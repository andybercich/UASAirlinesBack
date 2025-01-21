package org.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.Base;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Persona")
@Data
public class Persona extends Base {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private int dni;
    @Column(name = "mail")
    private String mail;
    @Column(name = "telefono")
    private int telefono;
}
