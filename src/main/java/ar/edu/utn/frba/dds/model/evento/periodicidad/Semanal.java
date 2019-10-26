package ar.edu.utn.frba.dds.model.evento.periodicidad;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Semanal implements PeriodicidadEvento {
    private DayOfWeek dia;
    private LocalDateTime actual = LocalDateTime.now();

    public Semanal(DayOfWeek dia) {
        this.dia = dia;
    }

    @Override
    public boolean tiempoDeNotificar(LocalDateTime fecha) {
        if (dia.equals(fecha.getDayOfWeek()) && fecha.isAfter(actual)) {
            actual = actual.plusWeeks(1);
            return true;
        }
        return false;
    }
}
