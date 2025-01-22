package org.example.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.enums.RolCabina;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PersonalCabina")
@Data
public class PersonalCabina extends Empleado {



    @Column(name = "Idiomas")
    private List<String> idiomas = new ArrayList<>();

    @Column(name = "RolCabina")
    private RolCabina rolCabina;

    @ManyToOne
    @JoinColumn(name = "tripulacion_id")
    private Tripulacion tripulacion;
}
