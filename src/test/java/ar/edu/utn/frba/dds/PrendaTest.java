package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.exceptions.ColorPrimarioIgualAlSecundarioException;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.Prenda;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorRemera;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.superior.remera.TipoRemeraCorta;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class PrendaTest {

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

/*    @Test
    public void cargarImagenAUnaPrenda(){
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta();
        Prenda remera = new Prenda(tipoRemeraCorta, Material.ALGODON, Color.BLACK);
        remera.setImagenPrenda("/home/dds/Escritorio/remeraNegra.jpg");
        Assert.assertEquals("/home/dds/TP/repo/DDS-GRUPO-6/images/TipoRemeraCortaALGODON.jpg", remera.getImagenPrenda());
    }*/

}
