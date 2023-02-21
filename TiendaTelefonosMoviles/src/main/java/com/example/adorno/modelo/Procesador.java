package com.example.adorno.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Procesador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private long numero_nucleos;


    private String modelo;


    private long velocidad;


    public Procesador() {
    }

    public Procesador(long numero_nucleos, String modelo, long velocidad) {

        this.numero_nucleos = numero_nucleos;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }
}
