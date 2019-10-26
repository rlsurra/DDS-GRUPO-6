package ar.edu.utn.frba.dds.model.categoria.superior;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;

import javax.persistence.Entity;

@Entity
public class CategoriaSuperiorCamisa extends CategoriaSuperior {

    public static final Categoria CATEGORIA_SUPERIOR_CAMISA = new CategoriaSuperiorCamisa();

    public CategoriaSuperiorCamisa() {
    }
}
