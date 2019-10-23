package ar.edu.utn.frba.dds.model.evento.notificador;

import ar.edu.utn.frba.dds.model.evento.Evento;

import javax.annotation.Nonnull;

public class NotificadorCorreo extends NotificadorExtra {
    public NotificadorCorreo(@Nonnull NotificadorEvento notificadorDecorado) {
        super(notificadorDecorado);
    }

    @Override
    public void notificar(@Nonnull Evento evento) {
        super.notificar(evento);
        // Logica para enviar correo
    }
}
