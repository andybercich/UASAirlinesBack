package org.example.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.Entities.enums.EstadoTripulacion;

import java.time.LocalDate;

@Entity
@Data
public class Tripulacion extends Base {

    @Enumerated(EnumType.STRING)
    @NotNull
    private EstadoTripulacion estado;

    @Column(name = "proximaCapacitacion")
    private LocalDate proximaCapacitacion;

    @OneToOne
    @JoinColumn(name = "capitan_id")
    @NotNull
    private Piloto capitan;

    @OneToOne
    @JoinColumn(name = "copiloto_id")
    @NotNull
    private Piloto copiloto;

}