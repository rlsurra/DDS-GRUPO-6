package ar.edu.utn.frba.dds.model.evento.periodicidad;

import java.time.LocalDateTime;

public interface PeriodicidadEvento {
    boolean tiempoDeNotificar(LocalDateTime fecha);
}
