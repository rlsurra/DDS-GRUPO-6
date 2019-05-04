package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Prenda {
    
    private TipoPrenda tipoPrenda;
    private Material material;
    private List<Color> colores  = new ArrayList<>();

    //TODO: Ver si tiene sentido que la prenda tenga el material en el constructor, ya que esta en el constructor de
    // Tipo de Prenda
    public Prenda(TipoPrenda tipoPrenda, Material material, List<Color> colores) {
        //CON ESTO ACCEDO A LA INSTANCIA UNICA CREADA
        ValidacionPrendaMaterial validacionPrendaMaterial = ValidacionPrendaMaterial.ValidacionPrendaMaterial();
        if(!validacionPrendaMaterial.validarPrenda(material,tipoPrenda.getClass())){
            //TODO: CAMBIAR EL SOUT POR LOGGER, USAR SLF4J de LOMBOK que es tremendo!
            System.out.println("Prenda no valida");
            throw new PrendaNoValidaException("COMBINACION TIPO DE PRENDA / MATERIAL NO VALIDA !");
        }
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colores = colores;
    }

    public Categoria getCategoria(){
        return tipoPrenda.getCategoria();
    }

}
