package ar.edu.utn.frba.dds.model.evento.periodicidad;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance
public abstract class PeriodicidadEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    boolean tiempoDeNotificar(LocalDateTime fecha) {
        return false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
