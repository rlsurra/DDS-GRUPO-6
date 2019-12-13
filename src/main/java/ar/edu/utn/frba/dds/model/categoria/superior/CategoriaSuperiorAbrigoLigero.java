package ar.edu.utn.frba.dds.model.categoria.superior;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;
import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.Entity;

@Entity
public class CategoriaSuperiorAbrigoLigero extends CategoriaSuperior {

    private static Categoria CATEGORIA_SUPERIOR_ABRIGO_LIGERO = null;

    public static Categoria getInstance(){
        if (CATEGORIA_SUPERIOR_ABRIGO_LIGERO == null){
            CATEGORIA_SUPERIOR_ABRIGO_LIGERO = Categoria.buscarCategoriaByNombre("CATEGORIA_SUPERIOR_ABRIGO_LIGERO");
            if (CATEGORIA_SUPERIOR_ABRIGO_LIGERO == null){
                CATEGORIA_SUPERIOR_ABRIGO_LIGERO = new CategoriaSuperiorAbrigoLigero("CATEGORIA_SUPERIOR_ABRIGO_LIGERO");
                Repositorio.getInstance().save(CATEGORIA_SUPERIOR_ABRIGO_LIGERO);
            }
        }
        return CATEGORIA_SUPERIOR_ABRIGO_LIGERO;
    }

    public CategoriaSuperiorAbrigoLigero() {
    }

    private CategoriaSuperiorAbrigoLigero(String nombre) {
    }
}
