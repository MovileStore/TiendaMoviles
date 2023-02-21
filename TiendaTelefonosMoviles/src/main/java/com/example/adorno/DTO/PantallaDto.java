package com.example.adorno.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.adorno.modelo.Pantalla} entity
 */
@Data
public class PantallaDto implements Serializable {
    private final long id;
    private final String tech_pantalla;
}