package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Piloto extends Empleado {

    private LocalDate fechaUltimaInspeccion;

    @Min(0)
    private int horasVuelo;

    @NotNull
    private int numLicencia;

    private LocalDate proximaPrueba;

    @NotBlank
    private String tipoLicencia;

}
