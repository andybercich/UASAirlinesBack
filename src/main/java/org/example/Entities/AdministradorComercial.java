package org.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AdministradorComercial")
@Data
public class AdministradorComercial extends org.example.Entities.Base {


    private String password;
    @Column(name = "user")
    private String user;

}
