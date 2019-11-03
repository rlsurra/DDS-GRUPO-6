package ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera;

import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorRemera;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;

import javax.persistence.Entity;

@Entity
public class TipoRemeraCorta extends TipoPrendaSuperior {

    public TipoRemeraCorta() {
        super(CategoriaSuperiorRemera.CATEGORIA_SUPERIOR_REMERA, 10.0);
    }
}
