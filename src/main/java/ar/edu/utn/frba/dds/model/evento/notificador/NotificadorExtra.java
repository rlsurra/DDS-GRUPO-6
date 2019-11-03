package ar.edu.utn.frba.dds.model.evento.notificador;

import ar.edu.utn.frba.dds.model.evento.Evento;

import javax.annotation.Nonnull;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Entity
public abstract class NotificadorExtra extends NotificadorEvento {

    @OneToOne(cascade = CascadeType.ALL)
    private NotificadorEvento notificadorDecorado;

    public NotificadorExtra(@Nonnull NotificadorEvento notificadorDecorado) {
        this.notificadorDecorado = notificadorDecorado;
    }

    public NotificadorExtra() {

    }

    @Override
    public void notificar(@Nonnull Evento evento) {
        notificadorDecorado.notificar(evento);
    }
}
