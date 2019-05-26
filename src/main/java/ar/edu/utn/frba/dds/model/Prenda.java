package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.exceptions.ColorPrimarioIgualAlSecundarioException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.exceptions.PrendaNoValidaException;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import lombok.Data;
import java.awt.*;

@Data
public class Prenda {
    
    private TipoPrenda tipoPrenda;
    private Material material;
    private Color colorPrimario;
    private Color colorSecundario;


    public Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrimario) {
        this(tipoPrenda,material,colorPrimario, null);
    }

    public Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrimario, Color colorSecundario) {
        validarParametrosInvalidos(tipoPrenda,material,colorPrimario);
        validarPrendaMaterial(tipoPrenda, material);
        validarColores(colorPrimario,colorSecundario);
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
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

    private void validarColores(Color primario,Color secundario) {
        if(primario.equals(secundario)){
            throw new ColorPrimarioIgualAlSecundarioException("El color primario debe ser distinto al secundario");
        }
    }

    private void validarParametrosInvalidos(TipoPrenda tipoPrenda, Material material,Color primario) {
        if(tipoPrenda == null || tipoPrenda.getCategoria() == null || material == null || primario == null){
            throw new ParametrosInvalidosException("Los parámetros no pueden ser vacíos");
        }
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "tipoPrenda=" + tipoPrenda.getClass().getSimpleName() +
                ", material=" + material +
                ", color primario =" + colorPrimario +
                ", color secundario =" + colorSecundario +
                '}' + System.getProperty("line.separator") ;
    }
}
