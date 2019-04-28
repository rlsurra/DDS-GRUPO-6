package ar.edu.utn.frba.dds;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Prenda {

    private TipoPrenda tipoPrenda;
    private Material material;
    private List<Color> colores  = new ArrayList<Color>();

    public Prenda(TipoPrenda tipoPrenda, Material material, List<Color> colores){
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colores = colores;
    }

    public Categoria getCategoria(){
        return tipoPrenda.getCategoria();
    }

}
