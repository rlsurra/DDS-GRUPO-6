package ar.edu.utn.frba.dds.model.evento;

import java.time.LocalDateTime;

public class EventoSimple extends Evento {
    private LocalDateTime fecha;

    public EventoSimple(String ciudad, LocalDateTime fecha) {
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
