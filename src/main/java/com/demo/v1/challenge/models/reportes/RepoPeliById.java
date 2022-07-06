package com.demo.v1.challenge.models.reportes;

import java.sql.Date;

public interface RepoPeliById {

    int getId();

    String getTitulo();

    Date getFecha();

    int getCalificacion();

    String getPersonaje();
}
