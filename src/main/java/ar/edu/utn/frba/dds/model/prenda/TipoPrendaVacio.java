package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.categoria.Categoria;

import javax.persistence.Entity;

@Entity
public class TipoPrendaVacio extends TipoPrenda {
    public TipoPrendaVacio() {
    }

    public TipoPrendaVacio(Categoria categoria) {
        super(categoria, 0d);
    }
}
