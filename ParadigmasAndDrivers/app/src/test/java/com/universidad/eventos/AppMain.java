package com.universidad.eventos;

import com.universidad.eventos.domain.Evento;
import com.universidad.eventos.repository.InMemoryEventoRepository;
import com.universidad.eventos.service.EventoService;

public class AppMain {

    public static void main(String[] args) {

        Evento evento = new Evento("Congreso de Ingeniería", 3);

        InMemoryEventoRepository repo = new InMemoryEventoRepository(evento);

        EventoService service = new EventoService(repo);

        service.registrarParticipante("1", "Ana");
        service.registrarParticipante("2", "Luis");

        System.out.println("Inscritos:");
        service.listarParticipantes()
                .forEach(p -> System.out.println(p.id() + " - " + p.nombre()));

        System.out.println("Cupos disponibles: " + service.cuposDisponibles());

        service.cancelarInscripcion("1");

        System.out.println("Cupos luego de cancelar: " + service.cuposDisponibles());
    }
}