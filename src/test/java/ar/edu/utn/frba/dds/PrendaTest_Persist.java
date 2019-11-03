package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.exceptions.ColorPrimarioIgualAlSecundarioException;
import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorRemera;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera.TipoRemeraCorta;
import org.junit.*;

import java.awt.*;

public class PrendaTest_Persist {

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
        Assert.assertEquals(remera.getCategoria(), CategoriaSuperiorRemera.CATEGORIA_SUPERIOR_REMERA);
    }

    @Test(expected = ColorPrimarioIgualAlSecundarioException.class)
    public void crearPrendaNoValidaPorColoresIguales() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta();
        new Prenda(tipoRemeraCorta, Material.ALGODON, Color.RED, Color.RED);
    }

    @Test
    public void instanciarUsuariosConGuardarropa() {
        GeneradorGuardarropa generadorGuardarropa = new GeneradorGuardarropa();
        generadorGuardarropa.getCasosDePrueba();
    }

    @Test
    @Ignore
    public void cargarImagenAUnaPrenda() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta();
        Prenda remera = new Prenda(tipoRemeraCorta, Material.ALGODON, Color.BLACK);
        remera.setImagenPrenda("/remeraNegra.jpg");
        Assert.assertEquals("/home/dds/TP/repo/DDS-GRUPO-6/images/TipoRemeraCortaALGODON.jpg", remera.getImagenPrenda());
    }

}
