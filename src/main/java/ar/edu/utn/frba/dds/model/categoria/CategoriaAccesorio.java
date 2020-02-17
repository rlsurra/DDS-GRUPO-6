package ar.edu.utn.frba.dds.model.categoria;

import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.Entity;

@Entity
public class CategoriaAccesorio extends Categoria {

    private static Categoria CATEGORIA_ACCESORIO = null;

    public static Categoria getInstance(){
        if (CATEGORIA_ACCESORIO == null){
            CATEGORIA_ACCESORIO = Categoria.buscarCategoriaByNombre("CATEGORIA_ACCESORIO");
            if (CATEGORIA_ACCESORIO == null){
                CATEGORIA_ACCESORIO = new CategoriaAccesorio("CATEGORIA_ACCESORIO");
                Repositorio.getInstance().save(CATEGORIA_ACCESORIO);
            }
        }
        return CATEGORIA_ACCESORIO;
    }

    public CategoriaAccesorio() {
    }

    private CategoriaAccesorio(String nombre) {
        this.nombre = nombre;
    }
}
