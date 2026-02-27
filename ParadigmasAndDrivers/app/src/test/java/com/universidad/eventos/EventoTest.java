package com.universidad.eventos;

import com.universidad.eventos.domain.Evento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    @Test
    void crearEvento_debeGuardarNombreYCupo() {
        Evento e = new Evento("Conferencia", 5);
        assertEquals("Conferencia", e.getNombre());
        assertEquals(5, e.getCupoDisponible());
    }

    @Test
    void disminuirCupo_debeReducirDisponibles() {
        Evento e = new Evento("Conferencia", 2);
        boolean ok = e.disminuirCupo();
        assertTrue(ok);
        assertEquals(1, e.getCupoDisponible());
    }

    @Test
    void disminuirCupo_noDebePermitirNegativos() {
        Evento e = new Evento("Conferencia", 1);
        e.disminuirCupo();
        boolean ok = e.disminuirCupo();
        assertFalse(ok);
        assertEquals(0, e.getCupoDisponible());
    }
}