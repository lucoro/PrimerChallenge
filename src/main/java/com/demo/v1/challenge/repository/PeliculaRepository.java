package com.demo.v1.challenge.repository;

import com.demo.v1.challenge.models.Pelicula;
import com.demo.v1.challenge.models.Personaje;
import com.demo.v1.challenge.models.reportes.Nombre;
import com.demo.v1.challenge.models.reportes.RepoPeliById;
import com.demo.v1.challenge.models.reportes.TituloDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PeliculaRepository extends CrudRepository<Pelicula,Integer> {


    @Query(value = " select pel.id as id, pel.titulo as titulo, pel.fecha_creacion as fecha, pel.calificacion as calificacion, per.nombre as personaje from pelicula as pel, personaje as per where pel.personaje_id = per.id and pel.id = :pelId", nativeQuery = true)
    Optional<RepoPeliById> getPeliculaById(@Param("pelId") int pelId) ;

    @Query(value = "select titulo as titulo, fecha_creacion as fecha from pelicula where titulo like %:name%", nativeQuery = true)
    Iterable<TituloDate> getPeliculaByName(@Param("name") String name) ;

    @Query(value = " select p.titulo as titulo , p.fecha_creacion as fecha from genero as g, pelicula as p where g.pelicula_id = p.id and g.id = :id", nativeQuery = true)
    Iterable<TituloDate> getPeliculaByGender(@Param("id") int id);

    @Query(value = "select titulo as titulo, fecha_creacion as fecha from pelicula order by 2 asc", nativeQuery = true)
    Iterable<TituloDate> getPeliculaAsc();

    @Query(value = "select titulo as titulo, fecha_creacion as fecha from pelicula order by 2 desc", nativeQuery = true)
    Iterable<TituloDate> getPeliculaDesc();


}
