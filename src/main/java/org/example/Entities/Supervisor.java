package org.example.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Supervisor extends Tecnico {


    private String password;

    @Column(name = "usuario")
    private String usuario;
}
