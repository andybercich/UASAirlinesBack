package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mantenimiento")
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

    @OneToMany
    @JoinColumn(name = "tecnico_id")
    private List<Tecnico> tecnicos;

    @OneToOne
    @JoinColumn(name = "estado_mantenimiento_id")
    private EstadoMantenimiento estadoMantenimiento;
}