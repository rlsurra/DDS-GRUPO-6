package ar.edu.utn.frba.dds.model.prenda.tipoPrenda;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Entidad;
import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = "selectTipoPrendaByCodigo", query = "SELECT u FROM TipoPrenda u WHERE u.codigo = :codigo"),
        @NamedQuery(name = "findallTipoPrenda", query = "SELECT u FROM TipoPrenda u")
})
public abstract class TipoPrenda extends Entidad {

    @OneToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    @Column
    private Double nivelDeCalor;

    @Column
    private String codigo;

    @OneToMany(
            orphanRemoval = false
    )
    private List<Material> materialesPermitidos = new ArrayList<>();

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

    public static List<TipoPrenda> findall(){
        TypedQuery<TipoPrenda> namedQuery = Repositorio.getInstance().getEntityManager().createNamedQuery("findallTipoPrenda", TipoPrenda.class);
        return namedQuery.getResultList();
    }

    public List<Material> getMaterialesPermitidos() {
        return materialesPermitidos;
    }

    public void setMaterialesPermitidos(List<Material> materialesPermitidos) {
        this.materialesPermitidos = materialesPermitidos;
    }
}
