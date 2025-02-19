package org.example.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.enums.Clase;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ConfiguracionCabina extends Base {

    @Column(name = "sistema_seguridad")
    private String sistemaSeguridad;

    @Column(name = "sistema_comunicacion")
    private String sistemaComunicacion;

    @Column(name = "modificaciones_realizadas")
    private String modificacionesRealizadas;

    private String entretenimineto;

    //Atributo distribucion asientos
    @ElementCollection
    @CollectionTable(name = "configuracion_clases", joinColumns = @JoinColumn(name = "configuracion_id"))
    @Column(name = "clase")
    @Enumerated(EnumType.STRING)
    List<Clase> clasesDisponibles = new ArrayList<>();
}