package ar.edu.utn.frba.dds.model.categoria;

import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.Entity;

@Entity
public class CategoriaCalzado extends Categoria {

    private static Categoria CATEGORIA_CALZADO = null;

    public static Categoria getInstance(){
        if (CATEGORIA_CALZADO == null){
            CATEGORIA_CALZADO = Categoria.buscarCategoriaByNombre("CATEGORIA_CALZADO");
            if (CATEGORIA_CALZADO == null){
                CATEGORIA_CALZADO = new CategoriaCalzado("CATEGORIA_CALZADO");
                Repositorio.getInstance().save(CATEGORIA_CALZADO);
            }
        }
        return CATEGORIA_CALZADO;
    }

    public CategoriaCalzado() {
    }

    private CategoriaCalzado(String nombre) {
        this.nombre = nombre;
    }
}
