package org.example.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.action.internal.OrphanRemovalAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Tecnico extends Empleado {


    @Column(name = "tipoLicencia")
    private String tipoLicencia;

    @Column(name = "VencimientoLicencia")
    private Date vencimientoLicencia;

    @ManyToMany(mappedBy = "tecnicos")
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

}
