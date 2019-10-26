package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.categoria.CategoriaCalzado;

import javax.persistence.Entity;

@Entity
public abstract class TipoPrendaCalzado extends TipoPrenda {

    public TipoPrendaCalzado() {
        super(CategoriaCalzado.CATEGORIA_CALZADO, 0.0);
    }
}
