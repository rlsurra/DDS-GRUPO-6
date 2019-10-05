package ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("N")
public class Normal extends ReferenciaTemperatura {

    public Normal(){
        this.setMaximo(60);
        this.setMinimo(40);
    }

}
