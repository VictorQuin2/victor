package com.universidad.eventos.repository;

import com.universidad.eventos.domain.Evento;
import com.universidad.eventos.domain.Participante;

import java.util.List;

public class InMemoryEventoRepository implements EventoRepository {

    private final Evento evento;

    public InMemoryEventoRepository(Evento evento) {
        this.evento = evento;
    }

    @Override
    public boolean inscribir(Participante participante) {
        return evento.inscribir(participante);
    }

    @Override
    public boolean cancelar(String idParticipante) {
        return evento.cancelar(idParticipante);
    }

    @Override
    public List<Participante> listarParticipantes() {
        return evento.getInscritos();
    }

    @Override
    public int cuposDisponibles() {
        return evento.getCupoDisponible();
    }
}