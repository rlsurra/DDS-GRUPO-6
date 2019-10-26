package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.exceptions.ColorPrimarioIgualAlSecundarioException;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.Prenda;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorRemera;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.superior.remera.TipoRemeraCorta;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.*;

public class PrendaTest_Persist {

    ///////////////////
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    /////////////////////


    @Test
    public void saberTipoDePrenda() {

        ////////////entity manager////////////

        emf = Persistence.createEntityManagerFactory("PERSISTENCE");
        manager = emf.createEntityManager();
        ////////////fin entity////////////


        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta();
        Prenda remera = new Prenda(tipoRemeraCorta, Material.ALGODON, Color.BLACK, Color.BLUE);
        Assert.assertEquals(tipoRemeraCorta, remera.getTipoPrenda());


        manager.getTransaction().begin();
        manager.persist(remera);
        manager.getTransaction().commit();
        manager.close();
        emf.close();


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
        remera.setImagenPrenda("/home/dds/Escritorio/remeraNegra.jpg");
        Assert.assertEquals("/home/dds/TP/repo/DDS-GRUPO-6/images/TipoRemeraCortaALGODON.jpg", remera.getImagenPrenda());
    }

}