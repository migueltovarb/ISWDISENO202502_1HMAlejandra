package com.proyectoelena.service;

import com.proyectoelena.domain.Asistencia;
import com.proyectoelena.domain.Certificado;
import com.proyectoelena.repository.AsistenciaRepository;
import com.proyectoelena.repository.CertificadoRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CertificadoService {
    private final CertificadoRepository certificadoRepository;
    private final AsistenciaRepository asistenciaRepository;

    public CertificadoService(CertificadoRepository certificadoRepository, AsistenciaRepository asistenciaRepository) {
        this.certificadoRepository = certificadoRepository;
        this.asistenciaRepository = asistenciaRepository;
    }

    public Certificado emitir(String eventoId, String usuarioId, String actorId) {
        Asistencia a = asistenciaRepository.findByEventoIdAndUsuarioId(eventoId, usuarioId).orElseThrow(() -> new IllegalArgumentException("asistencia"));
        if (!a.isAsistio()) throw new IllegalStateException("no asistio");
        Certificado c = new Certificado();
        c.setEventoId(eventoId);
        c.setUsuarioId(usuarioId);
        c.setEmitidoPorId(actorId);
        c.setFechaEmision(Instant.now());
        c.setPdfUrl("/certificados/" + usuarioId + "-" + eventoId + ".pdf");
        return certificadoRepository.save(c);
    }
}
