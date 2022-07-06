package com.demo.v1.challenge.models;

import javax.persistence.*;

@Entity
@Table(name = "genero")
public class Genero {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @OneToOne
    @JoinColumn(name = "pelicula_id", referencedColumnName = "id")
    private Pelicula peliculaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pelicula getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Pelicula peliculaId) {
        this.peliculaId = peliculaId;
    }
}
