package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Persona {

    @Id
    private Long id;
    public String nombre;
    private String tel;
}
