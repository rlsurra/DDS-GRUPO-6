package ar.edu.utn.frba.dds.model.prenda.tipoPrenda.inferior;

import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaInferior;

import javax.persistence.Entity;

@Entity
public class TipoJogging extends TipoPrendaInferior {

    public TipoJogging() {
        super(15.0);
    }
}
