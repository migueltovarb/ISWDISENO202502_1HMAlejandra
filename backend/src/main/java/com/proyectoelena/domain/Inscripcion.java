package com.proyectoelena.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "inscripciones")
public class Inscripcion {
    @Id
    private String id;
    private String usuarioId;
    private String eventoId;
    private Instant fechaInscripcion;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public String getEventoId() { return eventoId; }
    public void setEventoId(String eventoId) { this.eventoId = eventoId; }
    public Instant getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(Instant fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
}
