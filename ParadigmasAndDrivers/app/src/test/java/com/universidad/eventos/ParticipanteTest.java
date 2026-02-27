package com.universidad.eventos;
import com.universidad.eventos.domain.Participante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParticipanteTest {

    @Test
    public void crearParticipante_debeGuardarIdYNombre() {
        Participante p = new Participante("10", "Ana");

        assertEquals("10", p.getId());
        assertEquals("Ana", p.getNombre());
    }

}