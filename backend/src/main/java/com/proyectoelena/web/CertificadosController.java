package com.proyectoelena.web;

import com.proyectoelena.domain.Certificado;
import com.proyectoelena.service.CertificadoService;
import com.proyectoelena.web.dto.EmitirCertificadoRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/certificados")
public class CertificadosController {
    private final CertificadoService certificadoService;

    public CertificadosController(CertificadoService certificadoService) {
        this.certificadoService = certificadoService;
    }

    @PostMapping
    public ResponseEntity<Certificado> emitir(@Valid @RequestBody EmitirCertificadoRequest req) {
        return ResponseEntity.ok(certificadoService.emitir(req.eventoId(), req.usuarioId(), req.actorId()));
    }
}
