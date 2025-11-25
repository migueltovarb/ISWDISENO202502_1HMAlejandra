package com.proyectoelena.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistroUsuarioRequest(
        @Email @NotBlank String email,
        @NotBlank String nombreUsuario,
        @Size(min = 8) String password
) {}
