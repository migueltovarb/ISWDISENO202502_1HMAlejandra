package com.proyectoelena.service;

import com.proyectoelena.domain.Evento;
import com.proyectoelena.domain.Inscripcion;
import com.proyectoelena.repository.EventoRepository;
import com.proyectoelena.repository.InscripcionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class InscripcionService {
    private final InscripcionRepository inscripcionRepository;
    private final EventoRepository eventoRepository;
    private final EmailNotificationService emailNotificationService;

    public InscripcionService(InscripcionRepository inscripcionRepository, EventoRepository eventoRepository, EmailNotificationService emailNotificationService) {
        this.inscripcionRepository = inscripcionRepository;
        this.eventoRepository = eventoRepository;
        this.emailNotificationService = emailNotificationService;
    }

    public Inscripcion inscribir(String usuarioId, String eventoId) {
        Evento evento = eventoRepository.findById(eventoId).orElseThrow(() -> new IllegalArgumentException("evento"));
        if (evento.getCupos() != null) {
            int inscritos = evento.getInscritosIds() == null ? 0 : evento.getInscritosIds().size();
            if (inscritos >= evento.getCupos()) throw new IllegalStateException("sin cupos");
        }
        if (inscripcionRepository.findByEventoIdAndUsuarioId(eventoId, usuarioId).isPresent()) throw new IllegalStateException("ya inscrito");
        Inscripcion i = new Inscripcion();
        i.setEventoId(eventoId);
        i.setUsuarioId(usuarioId);
        i.setFechaInscripcion(Instant.now());
        Inscripcion saved = inscripcionRepository.save(i);
        if (evento.getInscritosIds() != null) {
            evento.getInscritosIds().add(usuarioId);
        }
        eventoRepository.save(evento);
        emailNotificationService.enqueueEmail(usuarioId, "Inscripcion", "Inscrito en evento");
        return saved;
    }
}
