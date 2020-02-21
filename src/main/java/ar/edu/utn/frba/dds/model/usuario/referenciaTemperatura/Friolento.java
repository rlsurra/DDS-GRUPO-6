package ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class Friolento extends ReferenciaTemperatura {

    public Friolento() {
        this.setMaximo(35);
        this.setMinimo(25);
    }

}
