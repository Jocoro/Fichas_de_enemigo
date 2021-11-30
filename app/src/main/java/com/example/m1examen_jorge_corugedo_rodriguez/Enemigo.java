package com.example.m1examen_jorge_corugedo_rodriguez;

public class Enemigo {
    String nombre;
    int edad;
    String descripcion;
    public Enemigo(String nombre, int edad, String descripcion){
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
