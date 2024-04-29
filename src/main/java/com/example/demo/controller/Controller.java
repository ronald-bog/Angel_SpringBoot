package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Repository repo;

    @GetMapping()
    public String index(){
        return "Hola Mundo";
    }

    @GetMapping("read")
    public List<Persona> get(){
        return repo.findAll();
    }

    @PostMapping("create")
    public void create(@RequestBody Persona persona){
        repo.save(persona);
    }

    @PutMapping("update/{id}")
    public String update(@PathVariable Long id, @RequestBody Persona persona){
        Persona per = repo.findById(id).get();
        per.setNombre(persona.getNombre());
        per.setTel(persona.getTel());
        repo.save(per);
        return "Editado Correctamente";
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        Persona per = repo.findById(id).get();
        repo.delete(per);
        return "Eliminado Correctamente";
    }
}
