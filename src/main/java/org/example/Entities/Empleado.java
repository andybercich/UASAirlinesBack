package org.example.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import org.example.Entities.enums.EstadoCivil;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Empleado extends Persona {

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @NotNull
    private LocalDate incorporacion;

    @NotNull
    private LocalDate vencimientoContrato;
}