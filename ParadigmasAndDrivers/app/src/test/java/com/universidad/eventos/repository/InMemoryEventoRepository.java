package com.universidad.eventos.repository;

import java.util.ArrayList;
import java.util.List;

import com.universidad.eventos.domain.Evento;
import com.universidad.eventos.domain.Participante;

// DRIVER: Escalabilidad -> estructura ligera en memoria
// DRIVER: Observabilidad -> logs en consola
public class InMemoryEventoRepository implements EventoRepository {

    private Evento evento;
    private List<Participante> inscritos = new ArrayList<>();


    public InMemoryEventoRepository(Evento evento) {
        this.evento = evento;
    }

    @Override
    public List<Participante> listarParticipantes() {
        // usamos la lista interna de inscritos
        return new java.util.ArrayList<>(inscritos);
    }

    @Override
    public boolean inscribir(Participante participante) {
        if (evento.disminuirCupo()) {
            inscritos.add(participante);
            System.out.println("LOG: Registrado " + participante.getNombre());
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelar(String idParticipante) {
        Participante p = inscritos.stream() // PARADIGMA FUNCIONAL
                .filter(x -> x.getId().equals(idParticipante))
                .findFirst()
                .orElse(null);

        if (p != null) {
            inscritos.remove(p);
            evento.aumentarCupo();
            System.out.println("LOG: Cancelado " + p.getNombre());
            return true;
        }
        return false;
    }

    @Override
    public List<Participante> listarInscritos() {
        return inscritos;
    }

    @Override
    public int cuposDisponibles() {
        return evento.getCupoDisponible();
    }


}