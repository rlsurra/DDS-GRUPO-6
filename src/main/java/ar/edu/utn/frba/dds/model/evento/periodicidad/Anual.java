package ar.edu.utn.frba.dds.model.evento.periodicidad;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

@Entity
public class Anual extends PeriodicidadEvento {

    @Column
    private Month mes;

    @Column
    private Year anioActual = Year.now();

    public Anual(Month mes) {
        this.mes = mes;
    }

    public Anual() {

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
