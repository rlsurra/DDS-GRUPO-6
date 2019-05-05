package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Prenda {
    
    private TipoPrenda tipoPrenda;
    private Material material;
    private List<Color> colores  = new ArrayList<>();

    //TODO: Ver si tiene sentido que la prenda tenga el material en el constructor, ya que esta en el constructor de
    // Tipo de Prenda
    public Prenda(TipoPrenda tipoPrenda, Material material, List<Color> colores) {

        validarPrendaMaterial(tipoPrenda, material);
        validarColores(colores);
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colores = colores;
    }

    public Categoria getCategoria(){
        return tipoPrenda.getCategoria();
    }

    private void validarPrendaMaterial(TipoPrenda tipoPrenda, Material material){
        ValidacionPrendaMaterial validacionPrendaMaterial = ValidacionPrendaMaterial.ValidacionPrendaMaterial();
        if(!validacionPrendaMaterial.validarPrenda(material,tipoPrenda.getClass())){
            //TODO: CAMBIAR EL SOUT POR LOGGER, USAR SLF4J de LOMBOK que es tremendo!
            System.out.println("Prenda no valida");
            throw new PrendaNoValidaException("COMBINACION TIPO DE PRENDA / MATERIAL NO VALIDA !");
        }
    }

    private void validarColores(List<Color> colores) {
        switch (colores.size()){
            case 0:
                System.out.println("PRENDA SIN COLORES DEFINIDOS");
                throw new PrendaNoValidaException("PRENDA SIN COLORES DEFINIDOS. NO VALIDO!");
            case 1:
                break;
            case 2:
                if( colores.get(0).equals(colores.get(1)) ) {
                    System.out.println("PRENDA CON COLOR PRINCIPAL IGUAL A SECUNDARIO");
                    throw new PrendaNoValidaException("PRENDA CON COLOR PRINCIPAL IGUAL A SECUNDARIO. NO VALIDO!");
                }
                break;
            default:
                System.out.println("PRENDA CON MAS DE 2 COLORES");
                throw new PrendaNoValidaException("PRENDA CON MAS DE 2 COLORES. NO VALIDO!");
        }
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "tipoPrenda=" + tipoPrenda.getClass().getSimpleName() +
                ", material=" + material +
                ", colores=" + colores +
                '}' + System.getProperty("line.separator") ;
    }
}
