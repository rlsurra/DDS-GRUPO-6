package ar.edu.utn.frba.dds.model.prenda.tipoPrenda;

import ar.edu.utn.frba.dds.model.categoria.CategoriaAccesorio;

import javax.persistence.Entity;

@Entity
public class TipoPrendaAccesorio extends TipoPrenda {

    public TipoPrendaAccesorio() {
        super(CategoriaAccesorio.getInstance(), 0.0);
    }
}
