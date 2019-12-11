package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.ValidacionPrendaMaterial;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera.TipoRemeraCorta;
import org.junit.Assert;
import org.junit.Test;

public class ValidacionPrendaMaterialTest {

    @Test
    public void validarMaterialYTipoDePrenda() {
        Material algodon = new Material("ALGODON");
        TipoRemeraCorta trm = new TipoRemeraCorta();
        trm.getMaterialesPermitidos().add(algodon);
        Assert.assertTrue(ValidacionPrendaMaterial.validarPrenda(algodon, trm));
    }

    @Test
    public void validarMaterialYTipoDePrendaError() {
        Material algodon = new Material("ALGODON");
        TipoRemeraCorta trm = new TipoRemeraCorta();
        trm.getMaterialesPermitidos().add(algodon);
        Assert.assertFalse(ValidacionPrendaMaterial.validarPrenda(new Material("CUERO"), trm));
    }

}
