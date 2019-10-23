package ar.edu.utn.frba.dds.model.categoria.superior;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;
import javax.persistence.Entity;

@Entity
public class CategoriaSuperiorRemera extends CategoriaSuperior {

    public static final Categoria CATEGORIA_SUPERIOR_REMERA =  new CategoriaSuperiorRemera();

    public CategoriaSuperiorRemera() {
    }
}
