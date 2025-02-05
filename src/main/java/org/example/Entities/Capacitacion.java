package org.example.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Capacitacion extends Base{

    @NotBlank
    private String nombre;

    @NotNull
    private LocalDate fechaInicio;

    @NotNull
    private LocalDate fechaFinal;

    @ManyToMany
    @JoinTable(name = "empleados_capacitaciones" ,
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "capacitacion_id") )
    private Set<Empleado> empleados = new HashSet<>();


}