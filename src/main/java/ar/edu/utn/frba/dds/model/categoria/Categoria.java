package ar.edu.utn.frba.dds.model.categoria;


import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.persistence.Entidad;
import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.*;

@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "selectCategoriaByNombre", query = "SELECT u FROM Categoria u WHERE u.nombre = :nombre")
})
public abstract class Categoria extends Entidad {

    public static Categoria buscarCategoriaByNombre(String nombre){
        try {
            TypedQuery<Categoria> namedQuery = Repositorio.getInstance().getEntityManager().createNamedQuery("selectCategoriaByNombre", Categoria.class);
            namedQuery.setParameter("nombre", nombre);
            return namedQuery.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
