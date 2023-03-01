package com.prueba.camilovaldivieeso.service;

import com.prueba.camilovaldivieeso.entities.Curso;
import com.prueba.camilovaldivieeso.entities.Depto;
import com.prueba.camilovaldivieeso.repository.CursoRepository;
import com.prueba.camilovaldivieeso.repository.DeptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DeptoServiceImpl  extends GenericServiceImpl<Depto, Long> implements DeptoService {

    @Autowired
    DeptoRepository deptoRepository;
    @Override
    public CrudRepository<Depto, Long> getDao() {
        return deptoRepository;
    }
}
