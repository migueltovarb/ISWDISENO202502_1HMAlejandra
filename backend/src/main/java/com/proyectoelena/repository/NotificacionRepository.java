package com.proyectoelena.repository;

import com.proyectoelena.domain.Notificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacionRepository extends MongoRepository<Notificacion, String> {
}
