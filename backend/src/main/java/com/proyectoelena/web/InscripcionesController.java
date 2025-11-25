package com.proyectoelena.web;

import com.proyectoelena.domain.Inscripcion;
import com.proyectoelena.service.InscripcionService;
import com.proyectoelena.web.dto.InscribirRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionesController {
    private final InscripcionService inscripcionService;

    public InscripcionesController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @PostMapping
    public ResponseEntity<Inscripcion> inscribir(@Valid @RequestBody InscribirRequest req) {
        return ResponseEntity.ok(inscripcionService.inscribir(req.usuarioId(), req.eventoId()));
    }
}
