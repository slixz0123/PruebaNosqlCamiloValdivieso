package com.prueba.camilovaldivieeso.repository;

import com.prueba.camilovaldivieeso.entities.Curso;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoRepository extends MongoRepository<Curso, Long> {
}
