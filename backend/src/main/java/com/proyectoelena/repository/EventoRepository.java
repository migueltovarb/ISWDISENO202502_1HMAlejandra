package com.proyectoelena.repository;

import com.proyectoelena.domain.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventoRepository extends MongoRepository<Evento, String> {
}
