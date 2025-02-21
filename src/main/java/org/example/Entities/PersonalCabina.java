package org.example.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.Entities.enums.RolCabina;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class PersonalCabina extends Empleado {


    @ManyToMany
    @JoinTable(
            name = "personal_cabina_idioma",
            joinColumns = @JoinColumn(name = "personal_cabina_id"),
            inverseJoinColumns = @JoinColumn(name = "idioma_id")
    )
    private List<Idioma> idioma = new ArrayList<>();

    @Column(name = "RolCabina")
    @Enumerated(EnumType.STRING)
    @NotNull
    private RolCabina rolCabina;

    @ManyToOne
    @JoinColumn(name = "tripulacion_id")
    private Tripulacion tripulacion;
}
