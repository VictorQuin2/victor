package com.universidad.eventos;

import com.universidad.eventos.domain.Evento;
import com.universidad.eventos.domain.Participante;
import com.universidad.eventos.repository.InMemoryEventoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryEventoRepositoryTest {

    @Test
    void inscribir_debeAgregarParticipante() {
        Evento e = new Evento("Test", 2);
        InMemoryEventoRepository repo = new InMemoryEventoRepository(e);

        boolean ok = repo.inscribir(new Participante("1", "Ana"));
        assertTrue(ok);
        assertEquals(1, repo.listarParticipantes().size());
    }

    @Test
    void cancelar_debeLiberarCupo() {
        Evento e = new Evento("Test", 1);
        InMemoryEventoRepository repo = new InMemoryEventoRepository(e);

        repo.inscribir(new Participante("1", "Ana"));
        repo.cancelar("1");

        assertEquals(1, repo.cuposDisponibles());
    }
}