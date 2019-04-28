package ar.edu.utn.frba.dds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidacionPrendaMaterialTest {
    private ValidacionPrendaMaterial validador;

    @Test
    public void validarMaterialYTipoDePrenda(){
        this.validador = new ValidacionPrendaMaterial();
        Assert.assertTrue(validador.validarPrenda(Material.ALGODON,TipoPrenda.REMERA_CORTA));
    }

}
