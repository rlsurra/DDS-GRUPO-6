package ar.edu.utn.frba.dds.model.evento.periodicidad;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

public class Anual implements PeriodicidadEvento {
    private Month mes;
    private Year anioActual = Year.now();

    public Anual(Month mes) {
        this.mes = mes;
    }

    @Override
    public boolean tiempoDeNotificar(LocalDateTime fecha) {
        if (mes.equals(fecha.getMonth()) && fecha.getYear() == anioActual.getValue()) {
            anioActual = anioActual.plusYears(1);
            return true;
        }
        return false;
    }
}
