package ar.edu.utn.frba.dds.model.prenda.tipoPrenda;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.categoria.CategoriaCalzado;

import javax.persistence.Entity;

@Entity
public class TipoPrendaCalzado extends TipoPrenda {

    public TipoPrendaCalzado() {
    }

    public TipoPrendaCalzado(Categoria categoria) { super(categoria, 0.0 );}

}
