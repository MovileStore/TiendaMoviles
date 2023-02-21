package com.example.adorno.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.adorno.modelo.Marca} entity
 */
@Data
public class MarcaDto implements Serializable {
    private final long id;
    private final String nombre;
}