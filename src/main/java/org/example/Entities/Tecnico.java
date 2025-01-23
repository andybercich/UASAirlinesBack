package org.example.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.action.internal.OrphanRemovalAction;

import java.util.Date;

@Entity
public class Tecnico extends Empleado {


    @Column(name = "tipoLicencia")
    private String tipoLicencia;

    @Column(name = "VencimientoLicencia")
    private Date vencimientoLicencia;

    @ManyToOne
    @JoinColumn(name = "fk_mantenimiento")
    private Mantenimiento mantenimiento;

}
