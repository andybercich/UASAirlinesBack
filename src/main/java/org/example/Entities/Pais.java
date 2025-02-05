package org.example.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.enums.Continente;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class Pais extends Base {

    @NotNull(message = "El país debe tener un nombre")
    @NotBlank(message = "El país debe tener un nombre")
    private String nombre;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "El país debe tener un continente asociado")
    private Continente continente;

}