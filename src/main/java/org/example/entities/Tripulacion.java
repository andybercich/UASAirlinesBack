package org.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.enums.EstadoTripulacion;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tripulacion")
@Data
public class Tripulacion extends Base{

    //ARRAY
    @Column(name = "capacitaciones")
    private String capacitaciones;
    @Column(name = "capitan")
    private Piloto capitan;
    @Column(name = "copiloto")
    private Piloto copiloto;
    @Column(name = "estado")
    private EstadoTripulacion estado;
    //ARRAY
    @Column(name = "personalCabina")
    private PersonalCabina personalCabina;
    @Column(name = "proximaCapacitacion")
    private Date proximaCapacitacion;
}
