package com.proyectoelena.web.dto;

import jakarta.validation.constraints.NotBlank;

public record RegistrarAsistenciaRequest(
        @NotBlank String eventoId,
        @NotBlank String usuarioId,
        @NotBlank String actorId,
        boolean asistio
) {}
