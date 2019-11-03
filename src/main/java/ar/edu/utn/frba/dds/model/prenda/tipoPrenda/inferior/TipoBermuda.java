package ar.edu.utn.frba.dds.model.prenda.tipoPrenda.inferior;

import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaInferior;

import javax.persistence.Entity;

@Entity
public class TipoBermuda extends TipoPrendaInferior {

    public TipoBermuda() {
        super(10.0);
    }
}
