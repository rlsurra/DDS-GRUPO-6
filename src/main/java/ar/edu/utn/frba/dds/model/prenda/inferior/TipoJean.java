package ar.edu.utn.frba.dds.model.prenda.inferior;

import ar.edu.utn.frba.dds.model.prenda.TipoPrendaInferior;

import javax.persistence.Entity;

@Entity
public class TipoJean extends TipoPrendaInferior {

    public TipoJean() {
        super(13.0);
    }
}
