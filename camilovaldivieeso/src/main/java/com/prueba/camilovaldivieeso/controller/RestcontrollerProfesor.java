package com.prueba.camilovaldivieeso.controller;

import com.prueba.camilovaldivieeso.entities.Profesor;
import com.prueba.camilovaldivieeso.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class RestcontrollerProfesor {
    @Autowired
    ProfesorService profesorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Profesor>> listarProfesores() {
        return new ResponseEntity<>(profesorService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Profesor> crearProfesores(
            @RequestBody Profesor p) {
        return new ResponseEntity<>(profesorService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesor> actualizarProfespres(@PathVariable Long id, @RequestBody Profesor p) {
        Profesor personaENcontrada = profesorService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setTelefono(p.getTelefono());
                personaENcontrada.setDireccion(p.getDireccion());
                return new ResponseEntity<>(profesorService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminarProfesor(@PathVariable Long id) {
        profesorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
