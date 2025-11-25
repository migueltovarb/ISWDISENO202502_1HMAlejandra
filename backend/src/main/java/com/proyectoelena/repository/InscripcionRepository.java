package com.proyectoelena.repository;

import com.proyectoelena.domain.Inscripcion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InscripcionRepository extends MongoRepository<Inscripcion, String> {
    List<Inscripcion> findByEventoId(String eventoId);
    Optional<Inscripcion> findByEventoIdAndUsuarioId(String eventoId, String usuarioId);
}
