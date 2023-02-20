package com.example.adorno.modelo;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Builder
@Data
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Movil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String nombre;

    @NonNull
    private String fecha_lanazamiento;

    @NonNull
    private long ram;

    @NonNull
    private long almacenamiento;

    @NonNull
    private long bateria;

    @NonNull
    private float pulgadas;

    @NonNull
    private long alto;

    @NonNull
    private long ancho;

    @NonNull
    private long grosor;

    @NonNull
    private long peso;

    @NonNull
    private long camara;

    @NonNull
    private boolean nfc;

    @NonNull
    private float precio;

    @ManyToOne
    private Marca marca;

    @ManyToOne
    private Pantalla pantalla;

    @ManyToOne
    private Procesador procesador;

    public Movil() {}

    public Movil(long id, @NonNull String nombre, @NonNull String fecha_lanazamiento, @NonNull long ram, @NonNull long almacenamiento, @NonNull long bateria, @NonNull float pulgadas, @NonNull long alto, @NonNull long ancho, @NonNull long grosor, @NonNull long peso, @NonNull long camara, @NonNull boolean nfc, @NonNull float precio, Marca marca, Pantalla pantalla, Procesador procesador) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_lanazamiento = fecha_lanazamiento;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.bateria = bateria;
        this.pulgadas = pulgadas;
        this.alto = alto;
        this.ancho = ancho;
        this.grosor = grosor;
        this.peso = peso;
        this.camara = camara;
        this.nfc = nfc;
        this.precio = precio;
        this.marca = marca;
        this.pantalla = pantalla;
        this.procesador = procesador;
    }
}
