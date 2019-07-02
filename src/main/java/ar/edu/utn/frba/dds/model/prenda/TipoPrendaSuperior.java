package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;

public abstract class TipoPrendaSuperior extends TipoPrenda {

//    public TipoPrendaSuperior(Double nivelDeCalor) {
//        super(CategoriaSuperior.CATEGORIA_SUPERIOR, nivelDeCalor);
//    }

    public TipoPrendaSuperior(Categoria categoria, Double nivelDeCalor) {
        super(categoria, nivelDeCalor);
    }
}
