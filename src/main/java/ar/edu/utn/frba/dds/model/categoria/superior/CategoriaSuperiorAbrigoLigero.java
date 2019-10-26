package ar.edu.utn.frba.dds.model.categoria.superior;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;

import javax.persistence.Entity;

@Entity
public class CategoriaSuperiorAbrigoLigero extends CategoriaSuperior {

    public static final Categoria CATEGORIA_SUPERIOR_ABRIGO_LIGERO = new CategoriaSuperiorAbrigoLigero();

    public CategoriaSuperiorAbrigoLigero() {
        super();
    }
}
