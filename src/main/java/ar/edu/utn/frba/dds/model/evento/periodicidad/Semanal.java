package ar.edu.utn.frba.dds.model.evento.periodicidad;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Entity
public class Semanal extends PeriodicidadEvento {

    @Column
    private DayOfWeek dia;

    @Column
    private LocalDateTime actual = LocalDateTime.now();

    public Semanal(DayOfWeek dia) {
        this.dia = dia;
    }

    public Semanal() {

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
