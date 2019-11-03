package ar.edu.utn.frba.dds.model.evento.notificador;

import ar.edu.utn.frba.dds.model.evento.Evento;

import javax.annotation.Nonnull;
import javax.persistence.Entity;

@Entity
public class NotificadorSms extends NotificadorExtra {
    public NotificadorSms(@Nonnull NotificadorEvento notificadorDecorado) {
        super(notificadorDecorado);
    }

    public NotificadorSms() {

    }

    @Override
    public void notificar(@Nonnull Evento evento) {
        super.notificar(evento);
        // Logica para enviar sms
    }
}
