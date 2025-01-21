package org.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.Base;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tecnico")
@Data
public class Tecnico extends Base {

    //ES UN ARRAY
    @Column(name = "Capacitaciones")
    private String Capacitaciones;

    @Column(name = "tipoLicencia")
    private String tipoLicencia;

    @Column(name = "VencimientoLicencia")
    private Date vencimientoLicencia;

}
