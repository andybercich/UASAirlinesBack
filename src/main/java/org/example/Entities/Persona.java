package org.example.Entities;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class Persona extends Base {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotNull
    private int dni;

    private String mail;


    private int telefono;

}