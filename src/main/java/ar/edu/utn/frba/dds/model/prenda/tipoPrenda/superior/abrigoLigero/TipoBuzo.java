package ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.abrigoLigero;

import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoLigero;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;

import javax.persistence.Entity;

@Entity
public class TipoBuzo extends TipoPrendaSuperior {

    public TipoBuzo() {
        super(CategoriaSuperiorAbrigoLigero.CATEGORIA_SUPERIOR_ABRIGO_LIGERO, 19.0);
    }
}
