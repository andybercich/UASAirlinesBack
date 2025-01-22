package org.example.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.enums.EstadoTripulacion;


import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tripulacion")
@Data
public class Tripulacion extends Base {

    //ARRAY
    @Column(name = "capacitaciones")
    private String capacitaciones;
    @Column(name = "estado")
    private EstadoTripulacion estado;
    @Column(name = "proximaCapacitacion")
    private Date proximaCapacitacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "capitan_id")
    private Piloto capitan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "copiloto_id")
    private Piloto copiloto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripulacion")
    private List<PersonalCabina> personalCabina;




}
