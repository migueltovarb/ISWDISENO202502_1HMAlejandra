package com.proyectoelena.web.dto;

import jakarta.validation.constraints.NotBlank;

public record ValidarPagoRequest(
        @NotBlank String adminId,
        boolean aprobado
) {}
