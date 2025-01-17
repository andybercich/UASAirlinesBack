package org.example.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ciudad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad extends Base {

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_pais")
    private Pais pais;

}