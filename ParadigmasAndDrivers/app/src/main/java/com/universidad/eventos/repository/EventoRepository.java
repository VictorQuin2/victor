package com.universidad.eventos.repository;

import java.util.List;

import com.universidad.eventos.domain.Participante;

public interface EventoRepository {

    List<Participante> listarParticipantes();

    boolean inscribir(Participante participante);

    boolean cancelar(String idParticipante);

    List<Participante> listarInscritos();

    int cuposDisponibles();
}