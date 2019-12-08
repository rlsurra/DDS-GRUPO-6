package ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.camisa;

import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorCamisa;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;

import javax.persistence.Entity;

@Entity
public class TipoCamisaLarga extends TipoPrendaSuperior {

    public TipoCamisaLarga() {
        super(CategoriaSuperiorCamisa.CATEGORIA_SUPERIOR_CAMISA, 15.0);
    }

}