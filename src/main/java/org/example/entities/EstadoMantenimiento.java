package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estado_mantenimiento")
@Data
public class EstadoMantenimiento extends Base {

    @Column(name = "ciclos")
    private int ciclos;

    @Column(name = "estado_actual")
    private String estadoActual;

    @Column(name = "fecha_ultimo_mantenimiento")
    private Date fechaUltimoMantenimiento;

    @Column(name = "horas_vuelo")
    private Double horasVuelo;

    @Column(name = "proxima_inspeccion")
    private Date proximaInspeccion;
}
