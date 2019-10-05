package ar.edu.utn.frba.dds.model.prenda.inferior;

import ar.edu.utn.frba.dds.model.prenda.TipoPrendaInferior;
import javax.persistence.Entity;

@Entity
public class TipoJogging extends TipoPrendaInferior {

    public TipoJogging(){
        super(15.0);
    }
}
