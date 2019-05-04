package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Prenda {
    
    private TipoPrenda tipoPrenda;
    private Material material;
    private List<Color> colores  = new ArrayList<>();

    //TODO: Pensar bien si esta bien que la prenda se inicialize con el MAterial.
    // el tipo de prenda de por si ya se crea con un material,

    public Prenda(TipoPrenda tipoPrenda, Material material, List<Color> colores) {
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colores = colores;
    }

    public Categoria getCategoria(){
        return tipoPrenda.getCategoria();
    }

}
