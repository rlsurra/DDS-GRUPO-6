package ar.edu.utn.frba.dds.model.evento.periodicidad;

import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;

import java.time.LocalDateTime;
import java.time.Month;

public class Mensual implements PeriodicidadEvento {
    private int diaDelMes;
    private Month mesActual = LocalDateTime.now().getMonth();

    public Mensual(int diaDelMes) {
        if (diaDelMes < 1 || diaDelMes > 31) {
            throw new ParametrosInvalidosException("Dia del mes incorrecto: " + diaDelMes);
        }
        this.diaDelMes = diaDelMes;
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
