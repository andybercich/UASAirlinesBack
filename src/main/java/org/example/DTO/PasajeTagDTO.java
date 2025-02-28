package org.example.DTO;

import org.example.Entities.enums.Clase;

public class PasajeTagDTO {

    private final String asiento;
    private final Clase clase;
    private final boolean vendido;

    public PasajeTagDTO(String asiento,  Clase clase, boolean vendido){

        this.asiento = asiento;
        this.clase = clase;
        this.vendido=vendido;

    }

}
