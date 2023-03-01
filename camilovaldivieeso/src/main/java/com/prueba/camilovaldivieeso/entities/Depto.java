package com.prueba.camilovaldivieeso.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection="Depto")
@Data
public class Depto {
    @Id
    private Long depto_ID;

    private String Nombre;
    private String Director;
    private String Descripcion;

    //relaciones






}
