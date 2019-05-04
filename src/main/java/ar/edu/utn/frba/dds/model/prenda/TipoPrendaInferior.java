package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.Categoria;
import ar.edu.utn.frba.dds.model.Material;

public abstract class TipoPrendaInferior extends TipoPrenda {

    public TipoPrendaInferior(Material material) {
        super(Categoria.INFERIOR, material);
    }
}
