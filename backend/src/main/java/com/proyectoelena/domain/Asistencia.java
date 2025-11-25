package com.proyectoelena.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "asistencias")
public class Asistencia {
    @Id
    private String id;
    private String eventoId;
    private String usuarioId;
    private boolean asistio;
    private Instant fechaRegistro;
    private String registradoPorId;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getEventoId() { return eventoId; }
    public void setEventoId(String eventoId) { this.eventoId = eventoId; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public boolean isAsistio() { return asistio; }
    public void setAsistio(boolean asistio) { this.asistio = asistio; }
    public Instant getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Instant fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public String getRegistradoPorId() { return registradoPorId; }
    public void setRegistradoPorId(String registradoPorId) { this.registradoPorId = registradoPorId; }
}
