package ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class Friolento extends ReferenciaTemperatura {

    public Friolento() {
        this.setMaximo(60);
        this.setMinimo(35);
    }

}
