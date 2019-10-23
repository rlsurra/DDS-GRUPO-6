package ar.edu.utn.frba.dds.model.evento.notificador;

import ar.edu.utn.frba.dds.model.evento.Evento;

import javax.annotation.Nonnull;

public class NotificadorSms extends NotificadorExtra {
    public NotificadorSms(@Nonnull NotificadorEvento notificadorDecorado) {
        super(notificadorDecorado);
    }

    @Override
    public void notificar(@Nonnull Evento evento) {
        super.notificar(evento);
        // Logica para enviar sms
    }
}
