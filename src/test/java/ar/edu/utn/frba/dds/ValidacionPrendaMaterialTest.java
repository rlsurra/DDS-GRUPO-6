package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.ValidacionPrendaMaterial;
import ar.edu.utn.frba.dds.model.prenda.TipoPrendaOLD;
import org.junit.Assert;
import org.junit.Test;

public class ValidacionPrendaMaterialTest {
    private ValidacionPrendaMaterial validador;

    @Test
    public void validarMaterialYTipoDePrenda(){
        this.validador = new ValidacionPrendaMaterial();
        Assert.assertTrue(validador.validarPrenda(Material.ALGODON, TipoPrendaOLD.REMERA_CORTA));
    }

}
