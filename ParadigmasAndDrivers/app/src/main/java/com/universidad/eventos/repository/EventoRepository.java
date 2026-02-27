package com.universidad.eventos.repository;

import com.universidad.eventos.domain.Participante;
import java.util.List;

public interface EventoRepository {

    boolean inscribir(Participante participante);
    boolean cancelar(String idParticipante);
    List<Participante> listarParticipantes();
    int cuposDisponibles();
}