package com.proyectoelena.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "eventos")
public class Evento {
    @Id
    private String id;
    private String nombreEvento;
    private String descripcion;
    private String lugar;
    private Instant fechaInicio;
    private Instant fechaFin;
    private Integer cupos;
    private String categoriaId;
    private List<String> organizadoresIds;
    private List<String> inscritosIds;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombreEvento() { return nombreEvento; }
    public void setNombreEvento(String nombreEvento) { this.nombreEvento = nombreEvento; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }
    public Instant getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Instant fechaInicio) { this.fechaInicio = fechaInicio; }
    public Instant getFechaFin() { return fechaFin; }
    public void setFechaFin(Instant fechaFin) { this.fechaFin = fechaFin; }
    public Integer getCupos() { return cupos; }
    public void setCupos(Integer cupos) { this.cupos = cupos; }
    public String getCategoriaId() { return categoriaId; }
    public void setCategoriaId(String categoriaId) { this.categoriaId = categoriaId; }
    public List<String> getOrganizadoresIds() { return organizadoresIds; }
    public void setOrganizadoresIds(List<String> organizadoresIds) { this.organizadoresIds = organizadoresIds; }
    public List<String> getInscritosIds() { return inscritosIds; }
    public void setInscritosIds(List<String> inscritosIds) { this.inscritosIds = inscritosIds; }
}
