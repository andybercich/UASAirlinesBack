package org.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.enums.EstadoCivil;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Empleado")
@Data
public class Empleado extends Persona {

    @Column(name = "EstadoCivil")
    private EstadoCivil estadoCivil;
    @Column(name = "Empleado")
    private Date incorporacion;
    @Column(name = "vencimientoContrato")
    private Date vencimientoContrato;
}
