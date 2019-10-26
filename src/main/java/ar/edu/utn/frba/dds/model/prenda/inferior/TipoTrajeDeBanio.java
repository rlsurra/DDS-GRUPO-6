package ar.edu.utn.frba.dds.model.prenda.inferior;

import ar.edu.utn.frba.dds.model.prenda.TipoPrendaInferior;

import javax.persistence.Entity;

@Entity
public class TipoTrajeDeBanio extends TipoPrendaInferior {

    public TipoTrajeDeBanio() {
        super(8.0);
    }
}
