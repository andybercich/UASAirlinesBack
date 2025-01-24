package org.example.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class VueloComercial extends Vuelo{


    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pasaje> pasajes = new ArrayList<>();


}
