package com.proyectoelena.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.List;

public record EditEventoRequest(
        @NotBlank String actorId,
        @NotBlank String nombreEvento,
        @NotBlank String descripcion,
        @NotBlank String lugar,
        @NotNull Instant fechaInicio,
        @NotNull Instant fechaFin,
        Integer cupos,
        String categoriaId,
        List<String> organizadoresIds
) {}
