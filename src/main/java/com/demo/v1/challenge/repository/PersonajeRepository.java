package com.demo.v1.challenge.repository;

import com.demo.v1.challenge.models.Personaje;
import com.demo.v1.challenge.models.reportes.Nombre;
import com.demo.v1.challenge.models.reportes.RepoPeliById;
import com.demo.v1.challenge.models.reportes.RepoPersonajeById;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface PersonajeRepository extends CrudRepository<Personaje,Integer> {

    @Query(value = "select per.id as id, per.nombre as nombre, per.edad as edad, per.peso_kg as peso, per.historia as historia, pel.titulo as pelicula from pelicula as pel, personaje as per where per.pelicula_id = pel.id and per.id = :perId", nativeQuery = true)
    Optional<RepoPersonajeById> getPersonajeById(@Param("perId") int perId) ;

    @Query(value = "select nombre from personaje where nombre like %:name%", nativeQuery = true)
    Iterable<Nombre> getNameByName(@Param("name") String nombre);


   @Query(value = "select per.nombre as nombre from personaje as per, pelicula as pel where per.pelicula_id = pel.id and pel.titulo like %:name%", nativeQuery = true)
    Iterable<Nombre> getNameByMovie(@Param("name") String nombre);


    @Query(value = "select nombre from personaje where edad = :edad ", nativeQuery = true)
    Iterable<Nombre> getNameByAge(@Param("edad") int edad) ;


}
