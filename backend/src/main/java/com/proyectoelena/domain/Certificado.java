package com.proyectoelena.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "certificados")
public class Certificado {
    @Id
    private String id;
    private String usuarioId;
    private String eventoId;
    private Instant fechaEmision;
    private String pdfUrl;
    private String emitidoPorId;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public String getEventoId() { return eventoId; }
    public void setEventoId(String eventoId) { this.eventoId = eventoId; }
    public Instant getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(Instant fechaEmision) { this.fechaEmision = fechaEmision; }
    public String getPdfUrl() { return pdfUrl; }
    public void setPdfUrl(String pdfUrl) { this.pdfUrl = pdfUrl; }
    public String getEmitidoPorId() { return emitidoPorId; }
    public void setEmitidoPorId(String emitidoPorId) { this.emitidoPorId = emitidoPorId; }
}
