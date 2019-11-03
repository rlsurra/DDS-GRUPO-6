package ar.edu.utn.frba.dds.model.prenda.tipoPrenda.inferior;

import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaInferior;

import javax.persistence.Entity;

@Entity
public class TipoJean extends TipoPrendaInferior {

    public TipoJean() {
        super(13.0);
    }
}
