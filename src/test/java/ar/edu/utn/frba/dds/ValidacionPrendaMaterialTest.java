package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.exceptions.PrendaNoValidaException;
import ar.edu.utn.frba.dds.model.Categoria;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.Prenda;
import ar.edu.utn.frba.dds.model.ValidacionPrendaMaterial;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoRemeraCorta;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Collections;

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
