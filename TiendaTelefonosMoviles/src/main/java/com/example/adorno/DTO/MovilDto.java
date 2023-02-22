package com.example.adorno.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.adorno.modelo.Movil} entity
 */
@EqualsAndHashCode(callSuper = true)
@Data

public record MovilDto(String marca, String nombre, Long nucleos, long ram, int almacenamiento,
                       float precio) implements Serializable {

}