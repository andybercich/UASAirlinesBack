package org.example.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Mantenimiento extends Base {

    @Column(name = "incidencia")
    private String incidencia;

    @Column(name = "inicio")
    private Date inicio;

    @Column(name = "fin")
    private Date fin;

    @Column(name = "programado")
    private boolean programado;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;

    @ManyToMany
    @JoinTable(
            name = "mantenimiento_tecnico",
            joinColumns = @JoinColumn(name = "mantenimiento_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id")
    )
    private List<Tecnico> tecnicos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "estado_mantenimiento_id")
    private EstadoMantenimiento estadoMantenimiento;
}