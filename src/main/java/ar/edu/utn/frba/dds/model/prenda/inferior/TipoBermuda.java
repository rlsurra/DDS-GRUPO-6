package ar.edu.utn.frba.dds.model.prenda.inferior;

import ar.edu.utn.frba.dds.model.prenda.TipoPrendaInferior;
import javax.persistence.Entity;

@Entity
public class TipoBermuda extends TipoPrendaInferior {

    public TipoBermuda(){
        super(10.0);
    }
}
