package com.proyectoelena.repository;

import com.proyectoelena.domain.Asistencia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AsistenciaRepository extends MongoRepository<Asistencia, String> {
    List<Asistencia> findByEventoId(String eventoId);
    Optional<Asistencia> findByEventoIdAndUsuarioId(String eventoId, String usuarioId);
}
