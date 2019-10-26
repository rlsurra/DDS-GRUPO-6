package ar.edu.utn.frba.dds.model.prenda.superior.abrigoPesado;

import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado;
import ar.edu.utn.frba.dds.model.prenda.TipoPrendaSuperior;

import javax.persistence.Entity;

@Entity
public class TipoBuzoPolar extends TipoPrendaSuperior {

    public TipoBuzoPolar() {
        super(CategoriaSuperiorAbrigoPesado.CATEGORIA_SUPERIOR_ABRIGO_PESADO, 25.0);
    }
}
