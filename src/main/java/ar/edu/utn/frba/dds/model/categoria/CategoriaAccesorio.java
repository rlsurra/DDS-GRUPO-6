package ar.edu.utn.frba.dds.model.categoria;

import javax.persistence.Entity;

@Entity
public class CategoriaAccesorio extends Categoria {

    public static final Categoria CATEGORIA_ACCESORIO = new CategoriaAccesorio();

    public CategoriaAccesorio() {
    }
}
