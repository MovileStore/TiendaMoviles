package com.example.adorno.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.adorno.modelo.Movil} entity
 */
@Data
public class MovilDto implements Serializable {
    private final long id;
    private final MarcaDto marca;
    private final String nombre;
    private final int almacenamiento;
    private final PantallaDto pantalla;
    private final Float pulgadasPantalla;
    private final ProcesadorDto procesador;
    private final long ram;
    private final long bateria;
    private final long camara;
    private final boolean nfc;
    private final String fecha_lanazamiento;
    private final long alto;
    private final long ancho;
    private final long grosor;
    private final long peso;
    private final float precio;
}