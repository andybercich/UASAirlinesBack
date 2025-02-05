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

    @ElementCollection
    @NotEmpty
    private List<String> idiomas = new ArrayList<>();

    @Column(name = "RolCabina")
    @Enumerated(EnumType.STRING)
    @NotNull
    private RolCabina rolCabina;

    @ManyToOne
    @JoinColumn(name = "tripulacion_id")
    private Tripulacion tripulacion;
}
