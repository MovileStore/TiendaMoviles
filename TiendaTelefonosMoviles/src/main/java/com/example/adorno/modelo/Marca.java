package com.example.adorno.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    String nombre;

    public Marca() {}

    public Marca(long id, @NonNull String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
