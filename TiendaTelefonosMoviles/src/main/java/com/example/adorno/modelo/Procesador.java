package com.example.adorno.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Procesador {
    @Id
    private long id;

    @NonNull
    private long numero_nucleos;

    @NonNull
    private String modelo;

    @NonNull
    private long velocidad;


    public Procesador() {}

    public Procesador(long id, @NonNull long numero_nucleos, @NonNull String modelo, @NonNull long velocidad) {
        this.id = id;
        this.numero_nucleos = numero_nucleos;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }
}
