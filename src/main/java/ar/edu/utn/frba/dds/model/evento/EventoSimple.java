package ar.edu.utn.frba.dds.model.evento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

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
