package com.example.adorno.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.adorno.modelo.Procesador} entity
 */
@Data
public class ProcesadorDto implements Serializable {
    private final long id;
    private final long numero_nucleos;
    private final String modelo;
    private final long velocidad;
}