package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.ValidacionPrendaMaterial;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera.TipoRemeraCorta;
import org.junit.Assert;
import org.junit.Test;

public class ValidacionPrendaMaterialTest {

    private ValidacionPrendaMaterial validador;

    @Test
    public void validarMaterialYTipoDePrenda() {
        this.validador = ValidacionPrendaMaterial.ValidacionPrendaMaterial();
        Assert.assertTrue(validador.validarPrenda(Material.ALGODON, new TipoRemeraCorta()));
    }

    @Test
    public void validarMaterialYTipoDePrendaError() {
        this.validador = ValidacionPrendaMaterial.ValidacionPrendaMaterial();
        Assert.assertFalse(validador.validarPrenda(Material.CUERO, new TipoRemeraCorta()));
    }

}
