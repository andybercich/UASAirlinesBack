package org.example.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.Base;
import org.example.entities.enums.Continente;

@Entity
@Table(name = "pais")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pais extends Base {

    private String nombre;

    @Enumerated(value = EnumType.STRING)
    private Continente continente;

}