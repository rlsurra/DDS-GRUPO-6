package ar.edu.utn.frba.dds.model.material;

import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.persistence.Entidad;
import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "selectMaterialByNombre", query = "SELECT u FROM Material u WHERE u.nombre = :nombre")
})
public class Material extends Entidad {

    public Material(){};

    public Material(String nombre){
        this.nombre = nombre;
    }

    public static Material buscarMaterialPorNombre(String nombre){
        try {
            TypedQuery<Material> namedQuery = Repositorio.getInstance().getEntityManager().createNamedQuery("selectMaterialByNombre", Material.class);
            namedQuery.setParameter("nombre", nombre);
            return namedQuery.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
