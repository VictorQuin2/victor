package com.universidad.eventos;

import com.universidad.eventos.domain.Evento;
import com.universidad.eventos.repository.InMemoryEventoRepository;
import com.universidad.eventos.service.EventoService;

public class AppMain {
    public static void main(String[] args) {

        Evento evento = new Evento("Congreso de Ingeniería", 2);
        InMemoryEventoRepository repo = new InMemoryEventoRepository(evento);
        EventoService service = new EventoService(repo, evento);

        service.registrarParticipante("1", "Ana");
        service.registrarParticipante("2", "Luis");

        System.out.println("Cupos disponibles: " + service.cuposDisponibles());

        service.registrarParticipante("3", "Pedro");

        service.cancelarInscripcion("1");

        System.out.println("Cupos después de cancelar: " + service.cuposDisponibles());
    }
}