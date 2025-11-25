package com.proyectoelena.domain;

import com.proyectoelena.domain.enums.EstadoNotificacion;
import com.proyectoelena.domain.enums.TipoNotificacion;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "notificaciones")
public class Notificacion {
    @Id
    private String id;
    private String usuarioId;
    private String asunto;
    private String mensaje;
    private TipoNotificacion tipo;
    private EstadoNotificacion estado;
    private Instant fechaEnvio;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public TipoNotificacion getTipo() { return tipo; }
    public void setTipo(TipoNotificacion tipo) { this.tipo = tipo; }
    public EstadoNotificacion getEstado() { return estado; }
    public void setEstado(EstadoNotificacion estado) { this.estado = estado; }
    public Instant getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(Instant fechaEnvio) { this.fechaEnvio = fechaEnvio; }
}
