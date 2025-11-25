package com.proyectoelena.web;

import com.proyectoelena.domain.Asistencia;
import com.proyectoelena.service.AsistenciaService;
import com.proyectoelena.web.dto.RegistrarAsistenciaRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciasController {
    private final AsistenciaService asistenciaService;

    public AsistenciasController(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    @PostMapping
    public ResponseEntity<Asistencia> registrar(@Valid @RequestBody RegistrarAsistenciaRequest req) {
        return ResponseEntity.ok(asistenciaService.registrar(req.eventoId(), req.usuarioId(), req.actorId(), req.asistio()));
    }
}
