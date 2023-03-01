package com.prueba.camilovaldivieeso.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection="Curso")
@Data
public class Curso {
    @Id
    private Long curso_id;

    private String Nombre;
    private String Nivel;
    private String Descripcion;




}
