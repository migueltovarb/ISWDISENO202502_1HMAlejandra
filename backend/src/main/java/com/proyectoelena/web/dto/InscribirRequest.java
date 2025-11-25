package com.proyectoelena.web.dto;

import jakarta.validation.constraints.NotBlank;

public record InscribirRequest(
        @NotBlank String usuarioId,
        @NotBlank String eventoId
) {}
