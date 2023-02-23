package com.example.adorno.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Procesador {

    @Id
    private long id;

    @OneToMany(mappedBy = "procesador")
    private List<Movil> movil;

    private long numero_nucleos;


    private String modelo;

    private long velocidad;

    public Procesador() {
    }

    public Procesador(long id, long numero_nucleos, String modelo, long velocidad) {
        this.id = id;
        this.numero_nucleos = numero_nucleos;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }
}