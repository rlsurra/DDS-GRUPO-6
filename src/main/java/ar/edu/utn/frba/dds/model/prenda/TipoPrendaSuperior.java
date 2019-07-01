package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.Categoria;

public abstract class TipoPrendaSuperior extends TipoPrenda {

    public TipoPrendaSuperior(Double nivelDeCalor) {
        super(Categoria.SUPERIOR, nivelDeCalor);
    }
}
