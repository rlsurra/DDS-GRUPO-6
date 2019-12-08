package ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.camisa;

import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorCamisa;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;

import javax.persistence.Entity;

@Entity
public class TipoCamisaCorta extends TipoPrendaSuperior {

    public TipoCamisaCorta() {
        super(CategoriaSuperiorCamisa.CATEGORIA_SUPERIOR_CAMISA, 12.0);
    }
}