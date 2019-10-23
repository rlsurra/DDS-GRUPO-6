package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.Prenda;
import ar.edu.utn.frba.dds.model.categoria.Categoria;

import java.awt.*;

import javax.persistence.Entity;

@Entity
public class PrendaVacio extends Prenda {
	public PrendaVacio() {
	}
	
    public PrendaVacio(Categoria categoria) {
        super(new TipoPrendaVacio(categoria), null, null);
    }

    @Override
    protected void validarPrendaMaterial(TipoPrenda tipoPrenda, Material material){
    }

    @Override
    protected void validarColores(Color primario, Color secundario) {
    }

    @Override
    protected void validarParametrosInvalidos(TipoPrenda tipoPrenda, Material material, Color primario) {
    }
}
