package org.example.DTO;

import lombok.Data;
import org.example.Entities.Aeropuerto;

import java.io.Serializable;

@Data
public class VueloTagDTO implements Serializable {

    private final String matricula;

    private final Long id;

    private final String ciudadOrigen;

    private final String aeropuertoOrigenAvrebiatura;

    private final String aeropuertoDestinoAvrebiatura;

    private final String ciudadDestino;

    private final double precio;

    public VueloTagDTO(String matricula, Long id, String ciudadOrigen,String aeropuertoOrigen,
                       String ciudadDestino, String aeropuertoDestino, double precio){
        this.matricula = matricula;
        this.id = id;
        this.ciudadOrigen = ciudadOrigen;
        this.aeropuertoOrigenAvrebiatura = aeropuertoOrigen;
        this.aeropuertoDestinoAvrebiatura = aeropuertoDestino;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
    }


}
