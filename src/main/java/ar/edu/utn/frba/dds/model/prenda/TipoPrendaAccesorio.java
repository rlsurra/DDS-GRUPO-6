package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.categoria.CategoriaAccesorio;

public abstract class TipoPrendaAccesorio extends TipoPrenda {

    public TipoPrendaAccesorio() {
        super(CategoriaAccesorio.CATEGORIA_ACCESORIO, 0.0);
    }
}
