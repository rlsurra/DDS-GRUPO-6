package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.categoria.Categoria;




public abstract class TipoPrenda {


    private Long id;

    private Categoria categoria;

    private Double nivelDeCalor;





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
