package com.demo.v1.challenge.controller;

import com.demo.v1.challenge.models.Genero;
import com.demo.v1.challenge.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/challenge/genero")
public class MainControllerGenero {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping(path = "/get/characters")
    public @ResponseBody
    Iterable<Genero> getGeneros(){
        return generoRepository.findAll();
    }

    @PostMapping(path = "/create",
            consumes="application/json", produces = "application/json")
    public Genero generoCreate(@RequestBody Genero newGenero){
        return generoRepository.save(newGenero);
    }


}
