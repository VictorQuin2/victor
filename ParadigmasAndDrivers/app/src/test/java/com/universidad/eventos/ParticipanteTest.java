package com.universidad.eventos;

import com.universidad.eventos.domain.Participante;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipanteTest {

    @Test
    void crearParticipante_debeGuardarIdYNombre() {
        Participante p = new Participante("1", "Ana");
        assertEquals("1", p.id());
        assertEquals("Ana", p.nombre());
    }
}