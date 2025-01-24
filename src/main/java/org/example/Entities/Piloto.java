package org.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
public class Piloto extends Empleado {

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

}
