package com.example.adorno.DTO;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.adorno.modelo.Pantalla} entity
 */
public record PantallaDto(long id, String tech_pantalla) implements Serializable {
}