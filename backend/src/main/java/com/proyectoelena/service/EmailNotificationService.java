package com.proyectoelena.service;

import com.proyectoelena.domain.Notificacion;
import com.proyectoelena.domain.enums.EstadoNotificacion;
import com.proyectoelena.domain.enums.TipoNotificacion;
import com.proyectoelena.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class EmailNotificationService {
    private final NotificacionRepository notificacionRepository;

    public EmailNotificationService(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    public void enqueueEmail(String usuarioId, String asunto, String mensaje) {
        Notificacion n = new Notificacion();
        n.setUsuarioId(usuarioId);
        n.setAsunto(asunto);
        n.setMensaje(mensaje);
        n.setTipo(TipoNotificacion.EMAIL);
        n.setEstado(EstadoNotificacion.PENDIENTE);
        n.setFechaEnvio(Instant.now());
        notificacionRepository.save(n);
    }
}
