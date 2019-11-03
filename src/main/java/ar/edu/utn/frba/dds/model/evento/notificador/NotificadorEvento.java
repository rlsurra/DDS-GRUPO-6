package ar.edu.utn.frba.dds.model.evento.notificador;

import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.persistence.Entidad;

import javax.annotation.Nonnull;
import javax.persistence.Entity;


@Entity
public abstract class NotificadorEvento extends Entidad {
    public void notificar(@Nonnull Evento evento) {};
}
