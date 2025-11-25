package com.proyectoelena.domain;

import com.proyectoelena.domain.enums.EstadoPago;
import com.proyectoelena.domain.enums.MetodoPago;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "pagos")
public class Pago {
    @Id
    private String id;
    private String usuarioId;
    private String eventoId;
    private Double monto;
    private MetodoPago metodoPago;
    private String comprobanteUrl;
    private EstadoPago estado;
    private String validadoPorId;
    private Instant fechaPago;
    private Instant fechaValidacion;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public String getEventoId() { return eventoId; }
    public void setEventoId(String eventoId) { this.eventoId = eventoId; }
    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }
    public String getComprobanteUrl() { return comprobanteUrl; }
    public void setComprobanteUrl(String comprobanteUrl) { this.comprobanteUrl = comprobanteUrl; }
    public EstadoPago getEstado() { return estado; }
    public void setEstado(EstadoPago estado) { this.estado = estado; }
    public String getValidadoPorId() { return validadoPorId; }
    public void setValidadoPorId(String validadoPorId) { this.validadoPorId = validadoPorId; }
    public Instant getFechaPago() { return fechaPago; }
    public void setFechaPago(Instant fechaPago) { this.fechaPago = fechaPago; }
    public Instant getFechaValidacion() { return fechaValidacion; }
    public void setFechaValidacion(Instant fechaValidacion) { this.fechaValidacion = fechaValidacion; }
}
