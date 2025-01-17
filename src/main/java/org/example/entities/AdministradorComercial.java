package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "administrador-comercial")
public class AdministradorComercial extends org.example.entities.Base {

    @Id
    private Long id;
}
