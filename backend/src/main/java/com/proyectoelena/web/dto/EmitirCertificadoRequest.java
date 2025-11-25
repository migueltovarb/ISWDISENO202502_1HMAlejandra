package com.proyectoelena.web.dto;

import jakarta.validation.constraints.NotBlank;

public record EmitirCertificadoRequest(
        @NotBlank String eventoId,
        @NotBlank String usuarioId,
        @NotBlank String actorId
) {}
