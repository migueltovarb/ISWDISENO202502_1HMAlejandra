package com.proyectoelena.service;

import com.proyectoelena.domain.Asistencia;
import com.proyectoelena.repository.AsistenciaRepository;
import com.proyectoelena.repository.InscripcionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AsistenciaService {
    private final AsistenciaRepository asistenciaRepository;
    private final InscripcionRepository inscripcionRepository;

    public AsistenciaService(AsistenciaRepository asistenciaRepository, InscripcionRepository inscripcionRepository) {
        this.asistenciaRepository = asistenciaRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    public Asistencia registrar(String eventoId, String usuarioId, String actorId, boolean asistio) {
        inscripcionRepository.findByEventoIdAndUsuarioId(eventoId, usuarioId).orElseThrow(() -> new IllegalStateException("no inscrito"));
        if (asistenciaRepository.findByEventoIdAndUsuarioId(eventoId, usuarioId).isPresent()) throw new IllegalStateException("duplicado");
        Asistencia a = new Asistencia();
        a.setEventoId(eventoId);
        a.setUsuarioId(usuarioId);
        a.setAsistio(asistio);
        a.setRegistradoPorId(actorId);
        a.setFechaRegistro(Instant.now());
        return asistenciaRepository.save(a);
    }
}
