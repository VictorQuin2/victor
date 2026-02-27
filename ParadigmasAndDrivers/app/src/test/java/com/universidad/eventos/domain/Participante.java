package com.universidad.eventos.domain;
/*
public class Participante {
    private String id;
    private String nombre;

    public Participante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}*/

public record Participante(String id, String nombre) {}