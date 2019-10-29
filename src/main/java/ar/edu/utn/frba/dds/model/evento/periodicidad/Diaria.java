package ar.edu.utn.frba.dds.model.evento.periodicidad;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Diaria extends PeriodicidadEvento {

    @Column
    private LocalTime time;

    @Column
    private int diaDelMes = LocalDateTime.now().getDayOfMonth();

    public Diaria(LocalTime time) {
        this.time = time;
    }

    public Diaria() {

    }

    @Override
    public boolean tiempoDeNotificar(LocalDateTime fecha) {
        if (time.getHour() == fecha.getHour() && diaDelMes == fecha.getDayOfMonth()) {
            diaDelMes = fecha.plusDays(1).getDayOfMonth();
            return true;
        }
        return false;
    }
}
