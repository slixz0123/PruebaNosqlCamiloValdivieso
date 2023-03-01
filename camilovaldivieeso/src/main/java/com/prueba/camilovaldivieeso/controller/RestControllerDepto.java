package com.prueba.camilovaldivieeso.controller;

import com.prueba.camilovaldivieeso.entities.Depto;
import com.prueba.camilovaldivieeso.entities.Profesor;
import com.prueba.camilovaldivieeso.service.DeptoService;
import com.prueba.camilovaldivieeso.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depto")
public class RestControllerDepto {
    @Autowired
    DeptoService depService;

    @GetMapping("/listar")
    public ResponseEntity<List<Depto>> listarDept() {
        return new ResponseEntity<>(depService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Depto> crearDept(
            @RequestBody Depto p) {
        return new ResponseEntity<>(depService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Depto> actualizarDept(@PathVariable Long id, @RequestBody Depto p) {
        Depto personaENcontrada = depService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setDescripcion(p.getDescripcion());
                personaENcontrada.setDirector(p.getDirector());
                return new ResponseEntity<>(depService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Depto> eliminarDept(@PathVariable Long id) {
        depService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
