package com.example.adorno.DTO;

import com.example.adorno.modelo.Marca;

/**
 * A DTO for the {@link com.example.adorno.modelo.Movil} entity
 */

public record MovilDto(Marca marca, String nombre, ProcesadorDto nucleosProcesador, long almacenamiento, long ram,
                       float precio) {
}