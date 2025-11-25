package com.proyectoelena.web.dto;

import com.proyectoelena.domain.enums.MetodoPago;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrarPagoRequest(
        @NotBlank String usuarioId,
        @NotBlank String eventoId,
        @NotNull Double monto,
        @NotNull MetodoPago metodoPago,
        String comprobanteUrl
) {}
