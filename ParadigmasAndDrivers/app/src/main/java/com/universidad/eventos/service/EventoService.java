package com.universidad.eventos.service;

import java.util.List;

import com.universidad.eventos.domain.Evento;
import com.universidad.eventos.domain.Participante;
import com.universidad.eventos.repository.EventoRepository;

// DRIVER: Mantenibilidad -> capa de servicio separa reglas de negocio
// DRIVER: Consistencia -> validaciones antes de acceder al repositorio
public class EventoService {

    private EventoRepository repository;
    private Evento evento;

    public EventoService(EventoRepository repository, Evento evento) {
        this.repository = repository;
        this.evento = evento;
    }

    // PARADIGMA IMPERATIVO: if/else + control de flujo
    public boolean registrarParticipante(String id, String nombre) {

        // Validar que exista cupo
        if (evento.getCupoDisponible() == 0) {
            System.out.println("LOG: No hay cupos disponibles.");
            return false;
        }

        // PARADIGMA FUNCIONAL: buscar duplicados con streams
        boolean yaExiste = repository.listarInscritos()
                .stream()
                .anyMatch(p -> p.getId().equals(id));

        if (yaExiste) {
            System.out.println("LOG: Participante ya inscrito.");
            return false;
        }

        Participante p = new Participante(id, nombre);
        return repository.inscribir(p);
    }

    public boolean cancelarInscripcion(String id) {
        return repository.cancelar(id);
    }

    public List<Participante> listarInscritos() {
        return repository.listarInscritos();
    }

    public int cuposDisponibles() {
        return repository.cuposDisponibles();
    }
}