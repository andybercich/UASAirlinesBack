package org.example.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.enums.EstadoTripulacion;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tripulacion extends Base {

    @Column(name = "estado")
    private EstadoTripulacion estado;

    @Column(name = "proximaCapacitacion")
    private Date proximaCapacitacion;

    @OneToOne
    @JoinColumn(name = "capitan_id")
    private Piloto capitan;

    @OneToOne
    @JoinColumn(name = "copiloto_id")
    private Piloto copiloto;

    @OneToMany(mappedBy = "tripulacion")
    private Set<PersonalCabina> personalCabina = new HashSet<>();




}
