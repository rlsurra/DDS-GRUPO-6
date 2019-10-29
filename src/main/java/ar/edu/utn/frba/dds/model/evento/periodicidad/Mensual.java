package ar.edu.utn.frba.dds.model.evento.periodicidad;

import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Month;

@Entity
public class Mensual extends PeriodicidadEvento {

    @Column
    private int diaDelMes;

    @Column
    private Month mesActual = LocalDateTime.now().getMonth();

    public Mensual(int diaDelMes) {
        if (diaDelMes < 1 || diaDelMes > 31) {
            throw new ParametrosInvalidosException("Dia del mes incorrecto: " + diaDelMes);
        }
        this.diaDelMes = diaDelMes;
    }

    public Mensual() {

    }

    @Override
    public boolean tiempoDeNotificar(LocalDateTime fecha) {
        if (diaDelMes == fecha.getDayOfMonth() && fecha.getMonth().equals(mesActual)) {
            mesActual = mesActual.plus(1);
            return true;
        }
        return false;
    }

}
