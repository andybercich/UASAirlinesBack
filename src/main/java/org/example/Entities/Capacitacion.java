package org.example.Entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Capacitacion extends Base{

    private String nombre;

    private LocalDate fechaInicio;

    private LocalDate fechaFinal;

    @ManyToMany
    @JoinTable(name = "empleados_capacitaciones" ,
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "capacitacion_id") )
    private Set<Empleado> empleados = new HashSet<>();


}
