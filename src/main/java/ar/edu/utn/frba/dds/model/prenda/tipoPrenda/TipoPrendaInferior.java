package ar.edu.utn.frba.dds.model.prenda.tipoPrenda;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.categoria.CategoriaInferior;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;

import javax.persistence.Entity;

@Entity
public class TipoPrendaInferior extends TipoPrenda {
    public TipoPrendaInferior() {
    }

    public TipoPrendaInferior(Categoria categoria) { super(categoria, 0.0 );}

    public TipoPrendaInferior(Double nivelDeCalor) {
        super(CategoriaInferior.getInstance(), nivelDeCalor);
    }
}
