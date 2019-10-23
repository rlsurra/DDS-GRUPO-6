package ar.edu.utn.frba.dds.model.prenda.superior.remera;

import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorRemera;
import ar.edu.utn.frba.dds.model.prenda.TipoPrendaSuperior;
import javax.persistence.Entity;

@Entity
public class TipoChomba extends TipoPrendaSuperior {

    public TipoChomba() {
        super(CategoriaSuperiorRemera.CATEGORIA_SUPERIOR_REMERA,12.0);
    }
}
