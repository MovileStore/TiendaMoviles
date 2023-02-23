package com.example.adorno.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Marca {
    @Id
    private long id;

    @OneToMany(mappedBy = "marca")
    private List<Movil> movil;

    String nombre;

    public Marca() {}

    public Marca(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}