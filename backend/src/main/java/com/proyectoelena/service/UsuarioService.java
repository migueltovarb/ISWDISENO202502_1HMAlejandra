package com.proyectoelena.service;

import com.proyectoelena.domain.Usuario;
import com.proyectoelena.domain.enums.Role;
import com.proyectoelena.repository.UsuarioRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.EnumSet;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final EmailNotificationService emailNotificationService;

    public UsuarioService(UsuarioRepository usuarioRepository, EmailNotificationService emailNotificationService) {
        this.usuarioRepository = usuarioRepository;
        this.emailNotificationService = emailNotificationService;
    }

    public Usuario registrar(String email, String nombreUsuario, String password) {
        if (!StringUtils.hasText(email)) throw new IllegalArgumentException("email requerido");
        if (!StringUtils.hasText(nombreUsuario)) throw new IllegalArgumentException("usuario requerido");
        if (password == null || password.length() < 8) throw new IllegalArgumentException("password corto");
        Optional<Usuario> existente = usuarioRepository.findByEmail(email);
        if (existente.isPresent()) throw new DuplicateKeyException("email registrado");
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setNombreUsuario(nombreUsuario);
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        u.setPasswordHash(hash);
        u.setRoles(EnumSet.of(Role.PARTICIPANTE));
        Usuario saved = usuarioRepository.save(u);
        emailNotificationService.enqueueEmail(saved.getId(), "Registro", "Confirma tu registro");
        return saved;
    }

    public Usuario getById(String id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("usuario"));
    }
}
