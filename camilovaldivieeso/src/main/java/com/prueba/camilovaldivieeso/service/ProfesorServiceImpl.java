package com.prueba.camilovaldivieeso.service;

import com.prueba.camilovaldivieeso.entities.Profesor;
import com.prueba.camilovaldivieeso.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor, Long> implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;
    @Override
    public CrudRepository<Profesor, Long> getDao() {
        return profesorRepository;
    }
}
