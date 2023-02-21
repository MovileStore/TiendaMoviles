package com.example.adorno.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Pantalla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String tech_pantalla;

    public Pantalla() {
    }

    public Pantalla(String tech_pantalla) {

        this.tech_pantalla = tech_pantalla;
    }
}
