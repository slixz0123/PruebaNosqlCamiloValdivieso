package com.prueba.camilovaldivieeso.repository;

import com.prueba.camilovaldivieeso.entities.Depto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeptoRepository extends MongoRepository<Depto, Long> {

}
