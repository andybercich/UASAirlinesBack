package org.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class AdministradorComercial extends Empleado {


    private String password;
    @Column(name = "user")
    private String user;

}
