package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.categoria.Categoria;

public class TipoPrendaVacio extends TipoPrenda {
    public TipoPrendaVacio(Categoria categoria) {
        super(categoria, 0d);
    }
}
