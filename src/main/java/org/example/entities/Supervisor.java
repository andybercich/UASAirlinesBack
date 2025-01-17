package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
