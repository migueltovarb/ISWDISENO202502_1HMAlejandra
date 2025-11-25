package com.proyectoelena.repository;

import com.proyectoelena.domain.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}
