package com.universidad.eventos.service;

import com.universidad.eventos.domain.Evento;
import com.universidad.eventos.domain.Participante;
import com.universidad.eventos.repository.EventoRepository;

import java.util.List;

public class EventoService {

    private final EventoRepository repository;
    private final Evento evento;

    public EventoService(EventoRepository repository, Evento evento) {
        this.repository = repository;
        this.evento = evento;
    }

    // REGISTRO DE PARTICIPANTES
    public boolean registrarParticipante(String id, String nombre) {

        // PARADIGMA FUNCIONAL: uso de streams para validar duplicados
        boolean yaExiste = repository.listarParticipantes()
                .stream()
                .anyMatch(p -> p.getId().equals(id));

        if (yaExiste) {
            System.out.println("LOG: Participante ya inscrito: " + id);
            return false;
        }

        // DRIVER: Consistencia de cupos
        if (!evento.disminuirCupo()) {
            System.out.println("LOG: No hay cupos disponibles");
            return false;
        }

        Participante nuevo = new Participante(id, nombre);
        boolean ok = repository.inscribir(nuevo);

        if (ok) {
            System.out.println("LOG: Registrado " + nombre);
        }

        return ok;
    }

    // CANCELACIÓN
    public boolean cancelarInscripcion(String id) {
        boolean ok = repository.cancelar(id);

        if (ok) {
            evento.aumentarCupo();
            System.out.println("LOG: Cancelada inscripción de " + id);
        }

        return ok;
    }

    // LISTADO (la que ya tenías)
    public List<Participante> listarInscritos() {
        return repository.listarParticipantes();
    }

    // DRIVER: verificación de cupos
    public int cuposDisponibles() {
        return repository.cuposDisponibles();
    }

    // Si ya tienes referencias a este método, lo dejamos como alias
    public List<Participante> listarParticipantes() {
        return repository.listarParticipantes();
    }
}