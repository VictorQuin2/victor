package com.universidad.eventos;

import com.universidad.eventos.domain.Evento;
import com.universidad.eventos.domain.Participante;
import com.universidad.eventos.repository.InMemoryEventoRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class InMemoryEventoRepositoryTest {

    @Test
    public void inscribir_debeAgregarParticipanteSiHayCupos() {
        Evento evento = new Evento("Test", 1);
        InMemoryEventoRepository repo = new InMemoryEventoRepository(evento);

        boolean resultado = repo.inscribir(new Participante("1", "Ana"));

        assertTrue(resultado);
    }

    @Test
    public void inscribir_noDebeAgregarCuandoNoHayCupos() {
        Evento evento = new Evento("Test", 0);
        InMemoryEventoRepository repo = new InMemoryEventoRepository(evento);

        boolean resultado = repo.inscribir(new Participante("1", "Ana"));

        assertFalse(resultado);
    }

    @Test
    public void cancelar_debeEliminarParticipante() {
        Evento evento = new Evento("Test", 2);
        InMemoryEventoRepository repo = new InMemoryEventoRepository(evento);

        repo.inscribir(new Participante("1", "Ana"));
        boolean eliminado = repo.cancelar("1");

        assertTrue(eliminado);
        assertEquals(2, evento.getCupoDisponible()); // porque volvió un cupo
    }
}