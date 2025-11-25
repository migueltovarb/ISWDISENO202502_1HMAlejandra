package com.proyectoelena.web;

import com.proyectoelena.domain.Evento;
import com.proyectoelena.service.EventoService;
import com.proyectoelena.web.dto.CreateEventoRequest;
import com.proyectoelena.web.dto.EditEventoRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventosController {
    private final EventoService eventoService;

    public EventosController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<Evento> crear(@Valid @RequestBody CreateEventoRequest req) {
        Evento e = new Evento();
        e.setNombreEvento(req.nombreEvento());
        e.setDescripcion(req.descripcion());
        e.setLugar(req.lugar());
        e.setFechaInicio(req.fechaInicio());
        e.setFechaFin(req.fechaFin());
        e.setCupos(req.cupos());
        e.setCategoriaId(req.categoriaId());
        e.setOrganizadoresIds(req.organizadoresIds());
        return ResponseEntity.ok(eventoService.crear(req.actorId(), e));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> editar(@PathVariable String id, @Valid @RequestBody EditEventoRequest req) {
        Evento e = new Evento();
        e.setNombreEvento(req.nombreEvento());
        e.setDescripcion(req.descripcion());
        e.setLugar(req.lugar());
        e.setFechaInicio(req.fechaInicio());
        e.setFechaFin(req.fechaFin());
        e.setCupos(req.cupos());
        e.setCategoriaId(req.categoriaId());
        e.setOrganizadoresIds(req.organizadoresIds());
        return ResponseEntity.ok(eventoService.editar(req.actorId(), id, e));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id, @RequestParam String actorId, @RequestParam boolean confirmar) {
        eventoService.eliminar(actorId, id, confirmar);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listar() {
        return ResponseEntity.ok(eventoService.listar());
    }
}
