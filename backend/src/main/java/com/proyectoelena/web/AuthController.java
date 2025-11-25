package com.proyectoelena.web;

import com.proyectoelena.domain.Usuario;
import com.proyectoelena.service.UsuarioService;
import com.proyectoelena.web.dto.RegistroUsuarioRequest;
import com.proyectoelena.web.dto.UsuarioResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioResponse> registrar(@Valid @RequestBody RegistroUsuarioRequest req) {
        Usuario u = usuarioService.registrar(req.email(), req.nombreUsuario(), req.password());
        return ResponseEntity.ok(new UsuarioResponse(u.getId(), u.getEmail(), u.getNombreUsuario()));
    }
}
