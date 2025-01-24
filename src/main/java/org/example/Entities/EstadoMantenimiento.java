package org.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
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
