package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.ValidacionPrendaMaterial;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoRemeraCorta;
import org.junit.Assert;
import org.junit.Test;

public class ValidacionPrendaMaterialTest {

    private ValidacionPrendaMaterial validador;

    @Test
    public void validarMaterialYTipoDePrenda() {
        this.validador = ValidacionPrendaMaterial.ValidacionPrendaMaterial();
        Assert.assertTrue(validador.validarPrenda(Material.ALGODON, TipoRemeraCorta.class));
        Assert.assertFalse(validador.validarPrenda(Material.CUERO, TipoRemeraCorta.class));
    }

}
