package com.prueba.camilovaldivieeso.service;

import com.prueba.camilovaldivieeso.entities.Curso;
import com.prueba.camilovaldivieeso.entities.Profesor;
import com.prueba.camilovaldivieeso.repository.CursoRepository;
import com.prueba.camilovaldivieeso.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl  extends GenericServiceImpl<Curso, Long> implements CursoService{

    @Autowired
    CursoRepository cursoRepository;
    @Override
    public CrudRepository<Curso, Long> getDao() {
        return cursoRepository;
    }
}
