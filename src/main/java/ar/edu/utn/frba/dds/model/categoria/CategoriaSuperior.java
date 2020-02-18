package ar.edu.utn.frba.dds.model.categoria;

import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class CategoriaSuperior extends Categoria {

    private static Categoria CATEGORIA_SUPERIOR = null;

    public static Categoria getInstance(){
        if (CATEGORIA_SUPERIOR == null){
            CATEGORIA_SUPERIOR = Categoria.buscarCategoriaByNombre("CATEGORIA_SUPERIOR");
            if (CATEGORIA_SUPERIOR == null){
                CATEGORIA_SUPERIOR = new CategoriaSuperior("CATEGORIA_SUPERIOR");
                Repositorio.getInstance().save(CATEGORIA_SUPERIOR);
            }
        }
        return CATEGORIA_SUPERIOR;
    }

    public CategoriaSuperior() {
    }

    private CategoriaSuperior(String nombre) {
        this.nombre = nombre;
    }
}
