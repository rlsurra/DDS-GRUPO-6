package ar.edu.utn.frba.dds.model.categoria.superior;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;

import javax.persistence.Entity;

@Entity
public class CategoriaSuperiorAbrigoPesado extends CategoriaSuperior {

    private static Categoria CATEGORIA_SUPERIOR_ABRIGO_PESADO = null;

    public static Categoria getInstance(){
        if (CATEGORIA_SUPERIOR_ABRIGO_PESADO == null){
            CATEGORIA_SUPERIOR_ABRIGO_PESADO = Categoria.buscarCategoriaByNombre("CATEGORIA_SUPERIOR_ABRIGO_PESADO");
            if (CATEGORIA_SUPERIOR_ABRIGO_PESADO == null){
                CATEGORIA_SUPERIOR_ABRIGO_PESADO = new CategoriaSuperiorAbrigoPesado("CATEGORIA_SUPERIOR_ABRIGO_PESADO");
            }
        }
        return CATEGORIA_SUPERIOR_ABRIGO_PESADO;
    }

    public CategoriaSuperiorAbrigoPesado() {
    }

    private CategoriaSuperiorAbrigoPesado(String nombre) {
    }
}
