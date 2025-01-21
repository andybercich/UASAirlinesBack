package org.example.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entities.Base;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "supervisor")
@Data
public class Supervisor extends Base {


    private String password;

    @Column(name = "usuario")
    private String usuario;
}
