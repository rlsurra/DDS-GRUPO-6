package ar.edu.utn.frba.dds.model.evento;

import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorEvento;
import ar.edu.utn.frba.dds.model.evento.periodicidad.PeriodicidadEvento;

import javax.persistence.*;

@Entity(name = "eventoperiodico")
@Table
public class EventoPeriodico extends Evento {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
