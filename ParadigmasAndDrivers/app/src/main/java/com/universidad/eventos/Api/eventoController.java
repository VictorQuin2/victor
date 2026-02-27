package com.universidad.eventos.Api;
import com.universidad.eventos.domain.Participante;
import com.universidad.eventos.service.EventoService;

import java.util.List;

class EventoController {

    private final EventoService service;

    public EventoController(EventoService service) {
        this.service = service;
    }

    public List<Participante> getListado() {
        return service.listarParticipantes();
    }

    public void postRegistrar(String id, String nombre) {
        service.registrarParticipante(id, nombre);
    }

    public void deleteCancelar(String id) {
        service.cancelarInscripcion(id);
    }

    public int getCupos() {
        return service.cuposDisponibles();
    }
}