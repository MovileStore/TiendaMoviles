package com.example.adorno.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
public class Procesador {
   @Id
   private long id;

    @OneToMany(mappedBy = "procesador")
    private List<Movil> movil;

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

    public Procesador(@NonNull long numero_nucleos, @NonNull String modelo, @NonNull long velocidad) {
        this.numero_nucleos = numero_nucleos;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }
}