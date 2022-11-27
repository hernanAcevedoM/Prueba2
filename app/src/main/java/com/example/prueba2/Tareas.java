package com.example.prueba2;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Tareas implements Serializable {
    private String titulo;
    private String descripcion;



    @NonNull
    @Override
    public String toString() {
        return titulo + " : descripción: " + descripcion;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
