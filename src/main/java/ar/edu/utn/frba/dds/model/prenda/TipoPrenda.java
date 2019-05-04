package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.Categoria;
import ar.edu.utn.frba.dds.model.Material;
import lombok.Data;

@Data
public abstract class TipoPrenda {

    private Categoria categoria;
    private Material material;

    public TipoPrenda(Categoria categoria, Material material) {
        this.categoria = categoria;
        this.material = material;
    }

}
