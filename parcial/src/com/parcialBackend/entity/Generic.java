package com.parcialBackend.entity;

public class Generic {
    private int id;
    private String nombre;

    // Constructores
    public Generic(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Generic(String nombre) {
        this.nombre = nombre;
    }

    // Getters & Setters
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

    @Override
    public String toString() {
        return "Id: " + id + " - Nombre: " + nombre ;
    }
}
