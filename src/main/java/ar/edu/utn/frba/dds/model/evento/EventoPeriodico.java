package ar.edu.utn.frba.dds.model.evento;

import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorEvento;
import ar.edu.utn.frba.dds.model.evento.periodicidad.PeriodicidadEvento;

public class EventoPeriodico extends Evento {
    private PeriodicidadEvento periodicidadEvento;

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
