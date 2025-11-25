package com.proyectoelena.service;

import com.proyectoelena.domain.EventHistory;
import com.proyectoelena.domain.Evento;
import com.proyectoelena.domain.Usuario;
import com.proyectoelena.domain.enums.Role;
import com.proyectoelena.repository.EventHistoryRepository;
import com.proyectoelena.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;
    private final EventHistoryRepository eventHistoryRepository;
    private final UsuarioService usuarioService;

    public EventoService(EventoRepository eventoRepository, EventHistoryRepository eventHistoryRepository, UsuarioService usuarioService) {
        this.eventoRepository = eventoRepository;
        this.eventHistoryRepository = eventHistoryRepository;
        this.usuarioService = usuarioService;
    }

    public Evento crear(String actorId, Evento e) {
        if (e.getInscritosIds() == null) e.setInscritosIds(new ArrayList<>());
        Evento saved = eventoRepository.save(e);
        registrarHistorial(saved.getId(), actorId, "CREAR", "Evento creado");
        return saved;
    }

    public Evento editar(String actorId, String id, Evento cambios) {
        Evento existente = eventoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("evento"));
        existente.setNombreEvento(cambios.getNombreEvento());
        existente.setDescripcion(cambios.getDescripcion());
        existente.setLugar(cambios.getLugar());
        existente.setFechaInicio(cambios.getFechaInicio());
        existente.setFechaFin(cambios.getFechaFin());
        existente.setCupos(cambios.getCupos());
        existente.setCategoriaId(cambios.getCategoriaId());
        existente.setOrganizadoresIds(cambios.getOrganizadoresIds());
        Evento saved = eventoRepository.save(existente);
        registrarHistorial(saved.getId(), actorId, "EDITAR", "Evento editado");
        return saved;
    }

    public void eliminar(String actorId, String id, boolean confirmar) {
        Usuario actor = usuarioService.getById(actorId);
        if (actor.getRoles() == null || !actor.getRoles().contains(Role.ADMIN)) throw new IllegalStateException("no autorizado");
        if (!confirmar) throw new IllegalArgumentException("confirmacion requerida");
        eventoRepository.deleteById(id);
        registrarHistorial(id, actorId, "ELIMINAR", "Evento eliminado");
    }

    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    private void registrarHistorial(String eventoId, String actorId, String accion, String detalle) {
        EventHistory h = new EventHistory();
        h.setEventoId(eventoId);
        h.setActorId(actorId);
        h.setAccion(accion);
        h.setDetalle(detalle);
        h.setFecha(Instant.now());
        eventHistoryRepository.save(h);
    }
}
