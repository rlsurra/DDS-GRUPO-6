package ar.edu.utn.frba.dds.model.categoria;

import javax.persistence.Entity;

@Entity
public class CategoriaCalzado extends Categoria {

    public static final Categoria CATEGORIA_CALZADO =  new CategoriaCalzado();

    public CategoriaCalzado() {
    }
}
