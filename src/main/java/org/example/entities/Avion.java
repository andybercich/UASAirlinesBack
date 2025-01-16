package org.example.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.enums.EstadoAvion;

import java.util.Date;

@Entity
@Table(name = "avion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avion extends Base {

    private double altitudMaximaVuelo;

    private int cantidadAsientos;

    private double capacidadCarga;

    private ConfiguracionCabina configuracion;

    private double consumoCombustibleKm;

    //Atributo distribucion

    private EstadoAvion estado;

    //Atributo estadoMantenimiento

    private String fabricante;

    private Date fechaCreacion;

    private String matricula;

    private String modelo;

    private String motores;

    private String numeroSerie;

    private double rangoVueloKm;

    //Atributo tripulacion

    private Aeropuerto ubicacionActual;

    private double velocidadMaxima;

    //Atributo Vuelo

    //Atributo Vuelo

}