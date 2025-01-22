package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

/*
        byte [][] configuracion = new byte[5][5];

        configuracion[0][0] = 0; //No hay nada

        configuracion[0][1] = 1; //Asiento libre Economico

        configuracion[0][2] = 2; //Asiento libre Business

        configuracion[0][3] = 3; //Asiento libre Primera clase

        configuracion[0][4] = 4; //Asiento ocupado economico

        configuracion[0][5] = 5; //Asiento ocupado Business

        configuracion[0][6] = 6; //Asiento ocupado primera clase */


        SpringApplication.run(Main.class, args);
        System.out.println("Aplicacion Iniciada");
    }
}