package ar.edu.utn.frba.dds.model.categoria;

import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.Entity;

@Entity
public class CategoriaInferior extends Categoria {

    private static Categoria CATEGORIA_INFERIOR = null;

    public static Categoria getInstance() {
        if (CATEGORIA_INFERIOR == null) {
            CATEGORIA_INFERIOR = Categoria.buscarCategoriaByNombre("CATEGORIA_INFERIOR");
            if (CATEGORIA_INFERIOR == null) {
                CATEGORIA_INFERIOR = new CategoriaInferior("CATEGORIA_INFERIOR");
                Repositorio.getInstance().save(CATEGORIA_INFERIOR);
            }
        }
        return CATEGORIA_INFERIOR;
    }

    public CategoriaInferior() {
    }

    private CategoriaInferior(String nombre) {
        this.nombre = nombre;
    }
}
