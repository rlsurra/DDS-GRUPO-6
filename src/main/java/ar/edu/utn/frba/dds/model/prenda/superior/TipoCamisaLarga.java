package ar.edu.utn.frba.dds.model.prenda.superior;

import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.prenda.TipoPrendaSuperior;

public class TipoCamisaLarga extends TipoPrendaSuperior {

    public TipoCamisaLarga(Material material) {
        super(material);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().substring(4) + " { " +
                "categoria=" + this.getCategoria() + ", material=" + this.getMaterial() + " }";
    }
}
