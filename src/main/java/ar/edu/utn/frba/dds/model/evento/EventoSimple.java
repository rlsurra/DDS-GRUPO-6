package ar.edu.utn.frba.dds.model.evento;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "eventosimple")
@Table
public class EventoSimple extends Evento {
	
	@Column
    private LocalDateTime fecha;
    
    public EventoSimple() {
	}
    
    public EventoSimple(Integer ciudad, LocalDateTime fecha) {
        super(ciudad);
        this.fecha = fecha;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
