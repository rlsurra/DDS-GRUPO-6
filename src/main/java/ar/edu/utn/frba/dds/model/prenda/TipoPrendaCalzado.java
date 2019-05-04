package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.Categoria;
import ar.edu.utn.frba.dds.model.Material;

public abstract class TipoPrendaCalzado extends TipoPrenda {

    public TipoPrendaCalzado(Material material) {
        super(Categoria.CALZADO, material);
    }
}
