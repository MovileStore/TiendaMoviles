package com.example.adorno.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

@Entity
@Builder
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Movil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Marca")
    private Marca marca;
    private String nombre;

    @Column(name = "ALMACENAMIENTO", nullable = false)
    private long almacenamiento;

    //@ManyToOne(cascade = CascadeType.ALL)

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pantalla", nullable = false)
    private Pantalla pantalla;

    @Column(name = "PULGADAS_PANTALLA", nullable = false)
    private long pulgadasPantalla;
    //@ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
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


    public Movil(long id, Marca marca, String nombre, long almacenamiento, Pantalla pantalla, long pulgadasPantalla, Procesador procesador, long ram, long bateria, long camara, boolean nfc, String fecha_lanazamiento, long alto, long ancho, long grosor, long peso, float precio) {
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.almacenamiento = almacenamiento;
        this.pantalla = pantalla;
        this.pulgadasPantalla = pulgadasPantalla;
        this.procesador = procesador;
        this.ram = ram;
        this.bateria = bateria;
        this.camara = camara;
        this.nfc = nfc;
        this.fecha_lanazamiento = fecha_lanazamiento;
        this.alto = alto;
        this.ancho = ancho;
        this.grosor = grosor;
        this.peso = peso;
        this.precio = precio;
    }

    public Movil(Marca marca, String nombre, long almacenamiento, Pantalla pantalla, long pulgadasPantalla, Procesador procesador, long ram, long bateria, long camara, boolean nfc, String fecha_lanazamiento, long alto, long ancho, long grosor, long peso, float precio) {
        this.marca = marca;
        this.nombre = nombre;
        this.almacenamiento = almacenamiento;
        this.pantalla = pantalla;
        this.pulgadasPantalla = pulgadasPantalla;
        this.procesador = procesador;
        this.ram = ram;
        this.bateria = bateria;
        this.camara = camara;
        this.nfc = nfc;
        this.fecha_lanazamiento = fecha_lanazamiento;
        this.alto = alto;
        this.ancho = ancho;
        this.grosor = grosor;
        this.peso = peso;
        this.precio = precio;
    }

    public Movil() {}
}
