package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.Categoria;
import ar.edu.utn.frba.dds.model.Material;

public abstract class TipoPrendaAccesorio extends TipoPrenda {

    public TipoPrendaAccesorio(Material material) {
        super(Categoria.ACCESORIO, material);
    }
}
