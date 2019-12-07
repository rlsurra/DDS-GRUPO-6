package ar.edu.utn.frba.dds.model.prenda.tipoPrenda;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Entidad;
import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.*;


@Entity
@NamedQueries({
        @NamedQuery(name = "selectTipoPrendaByCodigo", query = "SELECT u FROM TipoPrenda u WHERE u.codigo = :codigo")
})
public abstract class TipoPrenda extends Entidad {

    @OneToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    @Column
    private Double nivelDeCalor;

    @Column
    private String codigo;

    public TipoPrenda() {
    }


    public TipoPrenda(Categoria categoria, Double nivelDeCalor) {
        this.categoria = categoria;
        this.nivelDeCalor = nivelDeCalor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Double getNivelDeCalor() {
        return nivelDeCalor;
    }

    public void setNivelDeCalor(Double nivelDeCalor) {
        this.nivelDeCalor = nivelDeCalor;
    }

    public static TipoPrenda buscarTipoDePrendaPorCodigo(String codigo){
        try {
            TypedQuery<TipoPrenda> namedQuery = Repositorio.getInstance().getEntityManager().createNamedQuery("selectTipoPrendaByCodigo", TipoPrenda.class);
            namedQuery.setParameter("codigo", codigo);
            return namedQuery.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
