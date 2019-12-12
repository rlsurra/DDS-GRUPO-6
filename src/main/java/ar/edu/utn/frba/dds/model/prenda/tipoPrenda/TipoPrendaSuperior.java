package ar.edu.utn.frba.dds.model.prenda.tipoPrenda;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado;

import javax.persistence.Entity;

@Entity
public class TipoPrendaSuperior extends TipoPrenda {

//    public TipoPrendaSuperior(Double nivelDeCalor) {
//        super(CategoriaSuperior.CATEGORIA_SUPERIOR, nivelDeCalor);
//    }

    public TipoPrendaSuperior() {    }
    public TipoPrendaSuperior(Categoria categoria) { super(categoria, 0.0 );}

    public TipoPrendaSuperior(Categoria categoria, Double nivelDeCalor) {
        super(categoria, nivelDeCalor);
    }
}
