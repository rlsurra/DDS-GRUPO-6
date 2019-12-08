package ar.edu.utn.frba.dds.model.categoria;

import javax.persistence.Entity;

@Entity
public class CategoriaSuperior extends Categoria {

    public static final Categoria CATEGORIA_SUPERIOR = new CategoriaInferior();

    public CategoriaSuperior() {
    }
}
