package ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.abrigoPesado;

import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;

import javax.persistence.Entity;

@Entity
public class TipoCampera extends TipoPrendaSuperior {

    public TipoCampera() {
        super(CategoriaSuperiorAbrigoPesado.CATEGORIA_SUPERIOR_ABRIGO_PESADO, 23.0);
    }
}