package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class AdministradorComercial extends Empleado {

    @NotBlank
    private String password;

    @NotBlank
    private String user;

}
