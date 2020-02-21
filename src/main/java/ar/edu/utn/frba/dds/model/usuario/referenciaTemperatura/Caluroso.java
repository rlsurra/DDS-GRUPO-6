package ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Caluroso extends ReferenciaTemperatura {

    public Caluroso() {
        this.setMaximo(40);
        this.setMinimo(20);
    }

}
