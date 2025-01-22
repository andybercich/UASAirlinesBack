package org.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.enums.RolCabina;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PersonalCabina")
@Data
public class PersonalCabina extends Base {

    //ARRAY
    @Column(name = "Idiomas")
    private String idiomas;
    @Column(name = "RolCabina")
    private RolCabina rolCabina;
    @Column(name = "UbicacionActual")
    private String ubicacionActual;

}
