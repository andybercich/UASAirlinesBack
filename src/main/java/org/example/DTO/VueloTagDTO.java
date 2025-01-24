package org.example.DTO;

import org.example.Entities.Aeropuerto;

public class VueloTagDTO {

    private final String matricula;

    private final Long id;

    private final String ciudadOrigen;

    private final String aeropuertoOrigen;

    private final String aeropuertoDestino;

    private final String ciudadDestino;

    public VueloTagDTO(String matricula, Long id, String ciudadOrigen,String aeropuertoOrigen,
                       String ciudadDestino, String aeropuertoDestino){
        this.matricula = matricula;
        this.id = id;
        this.ciudadOrigen = ciudadOrigen;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.ciudadDestino = ciudadDestino;

    }


}
