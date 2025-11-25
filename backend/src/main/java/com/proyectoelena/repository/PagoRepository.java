package com.proyectoelena.repository;

import com.proyectoelena.domain.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PagoRepository extends MongoRepository<Pago, String> {
    List<Pago> findByEventoId(String eventoId);
    List<Pago> findByUsuarioId(String usuarioId);
}
