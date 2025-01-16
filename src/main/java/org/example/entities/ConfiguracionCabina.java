package org.example.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "configuracion_cabina")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfiguracionCabina extends Base {

    private String sistemaSeguridad;

    private String sistemaComunicacion;

    private String modificacionesRealizadas;

    private String entretenimineto;

    //Atributo distribucion asientos

    //Ver @
    private String [] clasesDisponibles;

}