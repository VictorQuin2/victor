package com.universidad.eventos.domain;

import java.util.ArrayList;
import java.util.List;

public class Evento {

    private String nombre;
    private int cupoMaximo;
    private int cupoDisponible;
    private List<Participante> inscritos = new ArrayList<>();

    public Evento(String nombre, int cupoMaximo) {
        this.nombre = nombre;
        this.cupoMaximo = cupoMaximo;
        this.cupoDisponible = cupoMaximo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCupoDisponible() {
        return cupoDisponible;
    }

    public boolean disminuirCupo() {
        if (cupoDisponible > 0) {
            cupoDisponible--;
            return true;
        }
        return false;
    }

    public void aumentarCupo() {
        if (cupoDisponible < cupoMaximo) {
            cupoDisponible++;
        }
    }

    public boolean inscribir(Participante p) {
        if (disminuirCupo()) {
            inscritos.add(p);
            return true;
        }
        return false;
    }

    public List<Participante> getInscritos() {
        return new ArrayList<>(inscritos);
    }
}