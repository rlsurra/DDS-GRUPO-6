package ar.edu.utn.frba.dds.model.prenda.tipoPrenda;

import ar.edu.utn.frba.dds.model.categoria.CategoriaCalzado;

import javax.persistence.Entity;

@Entity
public class TipoPrendaCalzado extends TipoPrenda {

    public TipoPrendaCalzado() {
        super(CategoriaCalzado.getInstance(), 0.0);
    }
}
