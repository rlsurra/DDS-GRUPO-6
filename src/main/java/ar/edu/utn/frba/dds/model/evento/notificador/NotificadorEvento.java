package ar.edu.utn.frba.dds.model.evento.notificador;

import ar.edu.utn.frba.dds.model.evento.Evento;

import javax.annotation.Nonnull;

public interface NotificadorEvento {
    void notificar(@Nonnull Evento evento);
}
