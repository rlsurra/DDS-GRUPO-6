package ar.edu.utn.frba.dds.model.prenda.tipoPrenda.inferior;

import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaInferior;

import javax.persistence.Entity;

@Entity
public class TipoTrajeDeBanio extends TipoPrendaInferior {

    public TipoTrajeDeBanio() {
        super(8.0);
    }
}
