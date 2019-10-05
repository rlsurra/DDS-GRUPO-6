package ar.edu.utn.frba.dds.model.evento;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorEvento;
import ar.edu.utn.frba.dds.model.evento.periodicidad.PeriodicidadEvento;

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
