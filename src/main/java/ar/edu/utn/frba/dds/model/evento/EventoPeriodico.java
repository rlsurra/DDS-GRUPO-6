package ar.edu.utn.frba.dds.model.evento;

import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorEvento;
import ar.edu.utn.frba.dds.model.evento.periodicidad.PeriodicidadEvento;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "eventoperiodico")
@Table
public class EventoPeriodico extends Evento {

    @Transient
    private PeriodicidadEvento periodicidadEvento;

    public EventoPeriodico() {
    }

    public EventoPeriodico(Integer ciudad, NotificadorEvento notificadorEvento, PeriodicidadEvento periodicidadEvento) {
        super(ciudad, notificadorEvento);
        this.periodicidadEvento = periodicidadEvento;
    }

    public PeriodicidadEvento getPeriodicidadEvento() {
        return periodicidadEvento;
    }

    public void setPeriodicidadEvento(PeriodicidadEvento periodicidadEvento) {
        this.periodicidadEvento = periodicidadEvento;
    }
}
