package ar.edu.utn.frba.dds.model.categoria;

import javax.persistence.Entity;

@Entity
public class CategoriaInferior extends Categoria {

    public static final Categoria CATEGORIA_INFERIOR =  new CategoriaInferior();

    public CategoriaInferior() {
    }
}
