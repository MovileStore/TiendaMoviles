package com.example.adorno.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.adorno.modelo.Pantalla} entity
 */
@Data
public record PantallaDto(long id, String tech_pantalla) implements Serializable {
}