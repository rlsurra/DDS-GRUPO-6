package ar.edu.utn.frba.dds.model.evento.notificador;

import ar.edu.utn.frba.dds.model.evento.Evento;

import javax.annotation.Nonnull;

public abstract class NotificadorExtra implements NotificadorEvento {
    private NotificadorEvento notificadorDecorado;

    public NotificadorExtra(@Nonnull NotificadorEvento notificadorDecorado) {
        this.notificadorDecorado = notificadorDecorado;
    }

    @Override
    public void notificar(@Nonnull Evento evento) {
        notificadorDecorado.notificar(evento);
    }
}
