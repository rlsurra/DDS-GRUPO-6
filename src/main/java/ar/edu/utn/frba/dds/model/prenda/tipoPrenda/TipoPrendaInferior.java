package ar.edu.utn.frba.dds.model.prenda.tipoPrenda;

import ar.edu.utn.frba.dds.model.categoria.CategoriaInferior;

import javax.persistence.Entity;

@Entity
public class TipoPrendaInferior extends TipoPrenda {
    public TipoPrendaInferior() {
    }

    public TipoPrendaInferior(Double nivelDeCalor) {
        super(CategoriaInferior.CATEGORIA_INFERIOR, nivelDeCalor);
    }
}
