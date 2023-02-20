package com.example.adorno.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Movil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "Marca")
    private Marca marca;
    private String nombre;

    @Column(name = "ALMACENAMIENTO", nullable = false)
    private int almacenamiento;

    @ManyToOne
    @JoinColumn(name = "Pantalla")
    private Pantalla pantalla;

    @Column(name = "PULGADAS_PANTALLA", nullable = false)
    private Float pulgadasPantalla;
    @ManyToOne
    @JoinColumn(name = "Procesador")
    private Procesador procesador;

    private long ram;
    private long bateria;

    private long camara;
    private boolean nfc;
    private String fecha_lanazamiento;
    private long alto;
    private long ancho;
    private long grosor;
    private long peso;

    private float precio;


    public Movil(long id, String nombre, Marca marca, String fecha_lanazamiento, long ram, int almacenamiento, long bateria, Pantalla pantalla, float pulgadasPantalla, Procesador procesador, long camara, long alto, long ancho, long grosor, long peso, boolean nfc, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.fecha_lanazamiento = fecha_lanazamiento;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.bateria = bateria;
        this.pantalla = pantalla;
        this.pulgadasPantalla = pulgadasPantalla;
        this.procesador = procesador;
        this.camara = camara;
        this.alto = alto;
        this.ancho = ancho;
        this.grosor = grosor;
        this.peso = peso;
        this.nfc = nfc;
        this.precio = precio;
    }
}
