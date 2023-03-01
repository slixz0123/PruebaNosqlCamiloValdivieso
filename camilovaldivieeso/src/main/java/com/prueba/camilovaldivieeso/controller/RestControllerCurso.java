package com.prueba.camilovaldivieeso.controller;

import com.prueba.camilovaldivieeso.entities.Curso;
import com.prueba.camilovaldivieeso.entities.Depto;
import com.prueba.camilovaldivieeso.service.CursoService;
import com.prueba.camilovaldivieeso.service.DeptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class RestControllerCurso {

    @Autowired
    CursoService cursService;

    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> listarcurso() {
        return new ResponseEntity<>(cursService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Curso> crearcurso(
            @RequestBody Curso p) {
        return new ResponseEntity<>(cursService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Curso> actualizarcurso(@PathVariable Long id, @RequestBody Curso p) {
        Curso personaENcontrada = cursService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setDescripcion(p.getDescripcion());
                personaENcontrada.setNivel(p.getNivel());
                return new ResponseEntity<>(cursService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Curso> eliminarcurso(@PathVariable Long id) {
        cursService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
