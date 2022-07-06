package com.demo.v1.challenge.controller;

import com.demo.v1.challenge.models.Personaje;
import com.demo.v1.challenge.models.reportes.Nombre;
import com.demo.v1.challenge.models.reportes.RepoPeliById;
import com.demo.v1.challenge.models.reportes.RepoPersonajeById;
import com.demo.v1.challenge.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path= "/challenge/personaje")
public class MainControllerPersonaje {


        @Autowired
        public PersonajeRepository personajeRepository;

        @GetMapping(path = "/get/characters")
        public @ResponseBody
        Iterable<Personaje> getAllPersonajes(){
            return personajeRepository.findAll();
        }


        @GetMapping(path = "/get/characters/personajeId/{perId}")
        public @ResponseBody
        Optional<RepoPersonajeById> getPersonajeById(@PathVariable("perId") int perId){
                return personajeRepository.getPersonajeById(perId);
        }
        @GetMapping(path = "/get/characters/name/{name}")
        public @ResponseBody
        Iterable<Nombre> getName(@PathVariable("name") String nombre){
                return personajeRepository.getNameByName(nombre);
        }

        @GetMapping(path = "/get/characters/edad/{edad}")
        public @ResponseBody
        Iterable<Nombre> getName2(@PathVariable("edad") int edad){
                return personajeRepository.getNameByAge(edad);
        }

        @GetMapping(path = "/get/characters/movie/{movie}")
        public @ResponseBody
        Iterable<Nombre> getName3(@PathVariable("movie") String movie){
                return personajeRepository.getNameByMovie(movie);
        }

        @PostMapping(path = "/create",
                consumes="application/json", produces = "application/json")
        public Personaje personajeCreate(@RequestBody Personaje newPersonaje){
                return personajeRepository.save(newPersonaje);
        }
        @PutMapping(path = "/update",
                consumes = "application/json", produces = "application/json")
        public Personaje updatePersonaje(@RequestBody Personaje updatePersonaje){
                return personajeRepository.save(updatePersonaje);
        }

        @DeleteMapping(path = "/delete/{personajeId}")
        public @ResponseBody
        Iterable<Personaje> deletePersonaje(@PathVariable("personajeId") int id_per){
                personajeRepository.deleteById(id_per);
                return personajeRepository.findAll();
        }
}
