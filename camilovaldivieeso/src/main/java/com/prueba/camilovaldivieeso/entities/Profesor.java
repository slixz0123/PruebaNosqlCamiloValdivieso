package com.prueba.camilovaldivieeso.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@Document(collection="profesor")
@Data
public class Profesor {

    @Id
    private Long prof_ID;

    private String nombre;
    private String Direccion;
    private String Telefono;

    //relaciones

    private Depto dep;
    private Curso listaCurso;







}
