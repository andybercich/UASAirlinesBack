package org.example.Entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Idioma extends Base{
    private String idioma;
}
