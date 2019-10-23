package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.categoria.CategoriaInferior;
import javax.persistence.Entity;

@Entity
public abstract class TipoPrendaInferior extends TipoPrenda {
	public TipoPrendaInferior() {
	}
    public TipoPrendaInferior(Double nivelDeCalor) {
        super(CategoriaInferior.CATEGORIA_INFERIOR, nivelDeCalor);
    }
}
