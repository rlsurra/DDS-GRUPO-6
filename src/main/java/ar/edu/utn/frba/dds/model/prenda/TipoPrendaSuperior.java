package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.Categoria;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;

public abstract class TipoPrendaSuperior extends TipoPrenda {

    public TipoPrendaSuperior(Material material) {
        super(Categoria.SUPERIOR, material);
    }
}
