package com.prueba.camilovaldivieeso.repository;

import com.prueba.camilovaldivieeso.entities.Profesor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfesorRepository  extends MongoRepository<Profesor, Long> {

}
