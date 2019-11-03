package ar.edu.utn.frba.dds.model.prenda.tipoPrenda;

import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.persistence.Entidad;

import javax.persistence.*;


@Entity
public abstract class TipoPrenda extends Entidad {

    @OneToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    @Column
    private Double nivelDeCalor;

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
}
