package com.universidad.eventos;

import com.universidad.eventos.domain.Evento;
import com.universidad.eventos.domain.Participante;
import com.universidad.eventos.repository.InMemoryEventoRepository;
import com.universidad.eventos.service.EventoService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class EventoServiceTest {

    @Test
    public void registrarParticipante_debeRegistrarSiHayCupos() {
        Evento evento = new Evento("Test", 1);
        EventoService service = new EventoService(
                new InMemoryEventoRepository(evento), evento
        );

        boolean ok = service.registrarParticipante("1", "Ana");

        assertTrue(ok);
        Assertions.assertEquals(0, service.cuposDisponibles());
    }

    @Test
    public void registrarParticipante_noDebeRegistrarSiNoHayCupos() {
        Evento evento = new Evento("Test", 0);
        EventoService service = new EventoService(
                new InMemoryEventoRepository(evento), evento
        );

        boolean ok = service.registrarParticipante("1", "Ana");

        Assertions.assertFalse(ok);
    }

    @Test
    public void cancelarInscripcion_debeLiberarCupo() {
        Evento evento = new Evento("Test", 2);
        EventoService service = new EventoService(
                new InMemoryEventoRepository(evento), evento
        );

        service.registrarParticipante("1", "Ana");
        service.cancelarInscripcion("1");

        Assertions.assertEquals(2, service.cuposDisponibles());
    }


    @Test
    public void listarInscritos_debeRetornarListaCorrecta() {
        Evento evento = new Evento("Test", 3);
        InMemoryEventoRepository repo = new InMemoryEventoRepository(evento);
        EventoService service = new EventoService(repo, evento);

        service.registrarParticipante("1", "Ana");
        service.registrarParticipante("2", "Luis");

        List<Participante> lista = service.listarParticipantes();

        assertEquals(2, lista.size());
        assertEquals("Ana", lista.get(0).getNombre());
    }


}