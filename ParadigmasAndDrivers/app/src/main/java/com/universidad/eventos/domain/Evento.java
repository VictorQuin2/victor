package com.universidad.eventos.domain;

// DRIVER: Consistencia de cupos -> esta clase garantiza que nunca haya sobrecupo
public class Evento {

    private String nombre;
    private int cupoMaximo;
    private int cupoDisponible;

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

    // PARADIGMA IMPERATIVO: if/else controla la lógica de negocio
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
}