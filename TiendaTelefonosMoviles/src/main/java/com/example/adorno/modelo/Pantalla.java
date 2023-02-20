package com.example.adorno.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Pantalla {
    @Id
    private long id;

    @NonNull
    private String tech_pantalla;

    public Pantalla() {}

    public Pantalla(long id, @NonNull String tech_pantalla) {
        this.id = id;
        this.tech_pantalla = tech_pantalla;
    }
}
