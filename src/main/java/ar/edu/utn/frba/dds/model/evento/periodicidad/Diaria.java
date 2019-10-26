package ar.edu.utn.frba.dds.model.evento.periodicidad;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Diaria implements PeriodicidadEvento {
    private LocalTime time;
    private int diaDelMes = LocalDateTime.now().getDayOfMonth();

    public Diaria(LocalTime time) {
        this.time = time;
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
