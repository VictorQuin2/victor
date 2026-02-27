package com.universidad.eventos.service;

import com.universidad.eventos.domain.Participante;
import com.universidad.eventos.repository.EventoRepository;

import java.util.List;

public class EventoService {

    private final EventoRepository repository;

    public EventoService(EventoRepository repository) {
        this.repository = repository;
    }

    public boolean registrarParticipante(String id, String nombre) {
        return repository.inscribir(new Participante(id, nombre));
    }

    public boolean cancelarInscripcion(String id) {
        return repository.cancelar(id);
    }

    public int cuposDisponibles() {
        return repository.cuposDisponibles();
    }

    public List<Participante> listarParticipantes() {
        return repository.listarParticipantes();
    }
}