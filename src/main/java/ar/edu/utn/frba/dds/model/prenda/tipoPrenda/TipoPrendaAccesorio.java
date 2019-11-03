package ar.edu.utn.frba.dds.model.prenda.tipoPrenda;

import ar.edu.utn.frba.dds.model.categoria.CategoriaAccesorio;

import javax.persistence.Entity;

@Entity
public abstract class TipoPrendaAccesorio extends TipoPrenda {

    public TipoPrendaAccesorio() {
        super(CategoriaAccesorio.CATEGORIA_ACCESORIO, 0.0);
    }
}
