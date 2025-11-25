package com.proyectoelena.repository;

import com.proyectoelena.domain.EventHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventHistoryRepository extends MongoRepository<EventHistory, String> {
    List<EventHistory> findByEventoIdOrderByFechaDesc(String eventoId);
}
