package org.example.DTO;

import org.example.Entities.Escala;

import java.time.ZonedDateTime;

public class EscalaTagDTO {

    private final ZonedDateTime llegada;

    private final ZonedDateTime salida;

    private final String matriculaAvion;

    private final String ciudad;

    private final String aeropuerto;

    public EscalaTagDTO(ZonedDateTime llegada, ZonedDateTime salida, String matriculaAvion, String ciudad, String aeropuerto){

        this.llegada = llegada;
        this.salida = salida;
        this.matriculaAvion = matriculaAvion;
        this.ciudad = ciudad;
        this.aeropuerto = aeropuerto;

    }

}
