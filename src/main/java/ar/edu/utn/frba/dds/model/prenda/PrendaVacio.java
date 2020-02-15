package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.categoria.Categoria;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaVacio;

import javax.persistence.Entity;
import java.awt.*;

@Entity
public class PrendaVacio extends Prenda {
    public PrendaVacio() {
    }

    public PrendaVacio(Categoria categoria) {
        super("", new TipoPrendaVacio(categoria), null, null);
    }

    @Override
    protected void validarPrendaMaterial(TipoPrenda tipoPrenda, Material material) {
    }

    @Override
    protected void validarColores(String primario, String secundario) {
    }

    @Override
    protected void validarParametrosInvalidos(TipoPrenda tipoPrenda, Material material, String primario) {
    }
}
