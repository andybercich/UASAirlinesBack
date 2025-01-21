package org.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.Base;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Piloto")
@Data
public class Piloto extends Base {

    @Column(name = "fechaUltimaInspeccion")
    private Date fechaUltimaInspeccion;
    @Column(name = "horasVuelo")
    private int horasVuelo;
    @Column(name = "numLicencia")
    private int numLicencia;
    @Column(name = "proximaPrueba")
    private Date proximaPrueba;
    @Column(name = "tipoLicencia")
    private String tipoLicencia;
    @Column(name = "ubicacionActual")
    private String ubicacionActual;
}
