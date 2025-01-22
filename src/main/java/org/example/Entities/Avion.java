package org.example.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.enums.EstadoAvion;

import java.util.Date;

@Entity
@Table(name = "avion")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    //Atributo distribucion

    @Enumerated(value = EnumType.STRING)
    private EstadoAvion estado;

    //Atributo estadoMantenimiento y su relacion

    private String fabricante;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    private String matricula;

    private String modelo;

    private String motores;

    @Column(name = "numero_serie")
    private String numeroSerie;

    @Column(name = "rango_vuelo_km")
    private double rangoVueloKm;

    //Atributo tripulacion

    @ManyToOne
    @JoinColumn(name = "fk_aeropuerto")
    private Aeropuerto ubicacionActual;

    @Column(name = "velocidad_maxima")
    private double velocidadMaxima;

    //Atributo vuelosAsignados de tipo Vuelo

    //Atributo vuelosProximos de tipo vuelo

}