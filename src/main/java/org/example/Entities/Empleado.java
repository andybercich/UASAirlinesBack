package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import org.example.Entities.enums.EstadoCivil;

import java.time.LocalDate;

@Entity
@Data
public class Empleado extends Persona {

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @NotNull
    private LocalDate incorporacion;

    @NotNull
    private LocalDate vencimientoContrato;

}