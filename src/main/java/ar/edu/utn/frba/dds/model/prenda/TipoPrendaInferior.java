package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.Categoria;

public abstract class TipoPrendaInferior extends TipoPrenda {

    public TipoPrendaInferior(Double nivelDeCalor) {
        super(Categoria.INFERIOR, nivelDeCalor);
    }
}
