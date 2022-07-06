package com.demo.v1.challenge.controller;

import com.demo.v1.challenge.models.Pelicula;
import com.demo.v1.challenge.models.reportes.RepoPeliById;
import com.demo.v1.challenge.models.reportes.TituloDate;
import com.demo.v1.challenge.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path= "/challenge/pelicula")
public class MainControllerPelicula {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @GetMapping(path = "/get/characters")
    public @ResponseBody
    Iterable<Pelicula> getPeliculas(){
        return peliculaRepository.findAll();
    }
    @GetMapping(path = "/get/characters/peliculaId/{pelId}")
    public @ResponseBody
    Optional<RepoPeliById> getPeliculaById(@PathVariable("pelId") int pelId){
        return peliculaRepository.getPeliculaById(pelId);
    }

    @GetMapping(path = "/get/characters/name/{name}")
    public @ResponseBody
    Iterable<TituloDate> getPelicula1(@PathVariable("name") String name){
        return peliculaRepository.getPeliculaByName(name);
    }

    @GetMapping(path = "/get/characters/gender/{gender}")
    public @ResponseBody
    Iterable<TituloDate> getPelicula2(@PathVariable("gender") int gender){
        return peliculaRepository.getPeliculaByGender(gender);
    }

    @GetMapping(path = "/get/characters/ASC")
    public @ResponseBody
    Iterable<TituloDate> getPelicula3() {
        return peliculaRepository.getPeliculaAsc();
    }

    @GetMapping(path = "/get/characters/DESC")
    public @ResponseBody
    Iterable<TituloDate> getPelicula4() {
        return peliculaRepository.getPeliculaDesc();
    }

    @PostMapping(path = "/create",
            consumes="application/json", produces = "application/json")
    public Pelicula peliculaCreate(@RequestBody Pelicula newPelicula){
        return peliculaRepository.save(newPelicula);
    }

    @PutMapping(path = "/update",
            consumes = "application/json", produces = "application/json")
    public Pelicula updatePelicula(@RequestBody Pelicula updatePelicula){
        return peliculaRepository.save(updatePelicula);
    }

    @DeleteMapping(path = "/delete/{peliculaId}")
    public @ResponseBody
    Iterable<Pelicula> deletePelicula(@PathVariable("peliculaId") int id_pel){
        peliculaRepository.deleteById(id_pel);
        return peliculaRepository.findAll();
    }
}

