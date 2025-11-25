package com.proyectoelena.repository;

import com.proyectoelena.domain.Certificado;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CertificadoRepository extends MongoRepository<Certificado, String> {
    List<Certificado> findByUsuarioId(String usuarioId);
    List<Certificado> findByEventoId(String eventoId);
}
