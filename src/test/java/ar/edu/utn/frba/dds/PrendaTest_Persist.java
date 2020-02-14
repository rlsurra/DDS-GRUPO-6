package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.exceptions.ColorPrimarioIgualAlSecundarioException;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;
import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;

public class PrendaTest_Persist {

    @Test
    public void saberTipoDePrenda() {
        Material ALGODON = new Material("ALGODON");
        TipoPrenda tipoRemeraCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        tipoRemeraCorta.getMaterialesPermitidos().add(ALGODON);
        Prenda remera = new Prenda(tipoRemeraCorta, ALGODON, "0|0|0|1", "0|0|255|1");
        Assert.assertEquals(tipoRemeraCorta, remera.getTipoPrenda());

    }


    @Test
    public void saberCategoria() {
        Material ALGODON = new Material("ALGODON");
        TipoPrenda tipoRemeraCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        tipoRemeraCorta.getMaterialesPermitidos().add(ALGODON);
        Prenda remera = new Prenda(tipoRemeraCorta, ALGODON, "0|0|0|1");
        Assert.assertEquals(remera.getCategoria(), CategoriaSuperior.getInstance());
    }

    @Test(expected = ColorPrimarioIgualAlSecundarioException.class)
    public void crearPrendaNoValidaPorColoresIguales() {
        Material ALGODON = new Material("ALGODON");
        TipoPrenda tipoRemeraCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        tipoRemeraCorta.getMaterialesPermitidos().add(ALGODON);
        new Prenda(tipoRemeraCorta, ALGODON, "255|0|0|1", "255|0|0|1");
    }

    @Test
    public void instanciarUsuariosConGuardarropa() {
        GeneradorGuardarropa generadorGuardarropa = new GeneradorGuardarropa();
        generadorGuardarropa.getCasosDePrueba();
    }

    @Test
    @Ignore
    public void cargarImagenAUnaPrenda() {
        Material ALGODON = new Material("ALGODON");
        TipoPrenda tipoRemeraCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        tipoRemeraCorta.getMaterialesPermitidos().add(ALGODON);
        Prenda remera = new Prenda(tipoRemeraCorta, ALGODON, "0|0|0|1");
        remera.setImagenPrenda("/remeraNegra.jpg");
        Assert.assertEquals("/home/dds/TP/repo/DDS-GRUPO-6/images/TipoRemeraCortaALGODON.jpg", remera.getImagenPrenda());
    }

}
