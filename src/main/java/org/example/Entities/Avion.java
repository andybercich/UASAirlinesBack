package org.example.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.enums.EstadoAvion;

import java.time.LocalDate;

@Entity
public class Avion extends Base {

    @Column(name = "altitud_maxima_vuelo")
    private double altitudMaximaVuelo;

    @Column(name = "cantidad_asientos")
    private int cantidadAsientos;

    @Column(name = "capacidad_carga")
    private double capacidadCarga;

    @OneToOne
    @JoinColumn(name = "fk_configuracion_cabina")
    private ConfiguracionCabina configuracion;

    @Column(name = "consumo_combustible_km")
    private double consumoCombustibleKm;


    @Enumerated(value = EnumType.STRING)
    private EstadoAvion estado;

    @OneToOne
    @JoinColumn(name = "fk_estado_mantenimiento")
    private EstadoMantenimiento estadoMantenimiento;

    private String fabricante;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    private String matricula;

    private String modelo;

    private String motores;

    @Column(name = "numero_serie")
    private String numeroSerie;

    @Column(name = "rango_vuelo_km")
    private double rangoVueloKm;

    @OneToOne
    @JoinColumn(name = "fk_tripulacion")
    private Tripulacion tripulacion;

    @ManyToOne
    @JoinColumn(name = "fk_aeropuerto")
    private org.example.Entities.Aeropuerto ubicacionActual;

    @Column(name = "velocidad_maxima")
    private double velocidadMaxima;

}