package ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera;

import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorRemera;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;

import javax.persistence.Entity;

@Entity
public class TipoRemeraLarga extends TipoPrendaSuperior {

    public TipoRemeraLarga() {
        super(CategoriaSuperiorRemera.CATEGORIA_SUPERIOR_REMERA, 15.0);
    }
}
