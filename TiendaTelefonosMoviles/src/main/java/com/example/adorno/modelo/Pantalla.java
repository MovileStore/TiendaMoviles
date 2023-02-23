package com.example.adorno.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
public class Pantalla {
    @Id
    private long id;

    @OneToMany(mappedBy = "pantalla")
    private List<Movil> movil;

    @NonNull
    private String tech_pantalla;

    public Pantalla() {
    }

    public Pantalla(long id, @NonNull String tech_pantalla) {
        this.id = id;
        this.tech_pantalla = tech_pantalla;
    }
}
