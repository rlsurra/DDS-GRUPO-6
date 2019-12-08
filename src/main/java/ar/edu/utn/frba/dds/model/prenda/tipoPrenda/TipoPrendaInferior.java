package ar.edu.utn.frba.dds.model.prenda.tipoPrenda;

import ar.edu.utn.frba.dds.model.categoria.CategoriaInferior;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;

import javax.persistence.Entity;

@Entity
public class TipoPrendaInferior extends TipoPrenda {
    public TipoPrendaInferior() {
        super(CategoriaInferior.CATEGORIA_INFERIOR, 0.0 );
    }

    public TipoPrendaInferior(Double nivelDeCalor) {
        super(CategoriaInferior.CATEGORIA_INFERIOR, nivelDeCalor);
    }
}
