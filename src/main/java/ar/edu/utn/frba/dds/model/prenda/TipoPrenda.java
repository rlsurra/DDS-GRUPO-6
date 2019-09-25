package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.categoria.Categoria;

import javax.persistence.*;


@Entity
@Table
public abstract class TipoPrenda {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

@Column
    private Double nivelDeCalor;

public TipoPrenda(){}



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
