package org.example.Entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "configuracion_cabina")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfiguracionCabina extends Base {

    @Column(name = "sistema_seguridad")
    private String sistemaSeguridad;

    @Column(name = "sistema_comunicacion")
    private String sistemaComunicacion;

    @Column(name = "modificaciones_realizadas")
    private String modificacionesRealizadas;

    private String entretenimineto;

    //Atributo distribucion asientos

    @Column(name = "clases_disponibles")
    List<String> clasesDisponibles = new ArrayList<>();

}