package ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("N")
public class Normal extends ReferenciaTemperatura {

    public Normal() {
        this.setMaximo(25);
        this.setMinimo(15);
    }

}
