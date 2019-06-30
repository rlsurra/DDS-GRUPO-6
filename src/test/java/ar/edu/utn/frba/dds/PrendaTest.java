package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.exceptions.ColorPrimarioIgualAlSecundarioException;
import ar.edu.utn.frba.dds.model.*;
import ar.edu.utn.frba.dds.exceptions.PrendaNoValidaException;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoRemeraCorta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrendaTest {
    //Debe saberse que tipo de prenda es

    @Test
    public void saberTipoDePrenda() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta();
        Prenda remera = new Prenda(tipoRemeraCorta, Material.ALGODON, Color.BLACK, Color.BLUE);
        Assert.assertEquals(tipoRemeraCorta, remera.getTipoPrenda());
    }
    @Test
    public void saberCategoria() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta();
        Prenda remera = new Prenda(tipoRemeraCorta, Material.ALGODON, Color.BLACK);
        Assert.assertEquals(remera.getCategoria(), Categoria.SUPERIOR);
    }

    @Test (expected = ColorPrimarioIgualAlSecundarioException.class)
    public void crearPrendaNoValidaPorColoresIguales() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta();
        new Prenda(tipoRemeraCorta, Material.ALGODON, Color.RED, Color.RED);
    }

    @Test
    public void instanciarUsuariosConGuardarropa(){
        GeneradorGuardarropa generadorGuardarropa = new GeneradorGuardarropa();
        generadorGuardarropa.getCasosDePrueba();
    }

}
