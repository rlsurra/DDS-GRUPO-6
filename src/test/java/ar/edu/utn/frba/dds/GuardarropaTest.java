package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.*;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoCamisaCorta;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoRemeraCorta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;


public class GuardarropaTest {

    private Guardarropa guardarropa;

    @Before
    public void setUp(){
        guardarropa = new Guardarropa();
        Usuario user = new Usuario();

    }

    @Test
    public void guardarPrendaEnUnGuardarropa() {
        //CREAR UNA REMERA DEL TIPO CORTA Y CATEGORIA SUPEROR, QUE DEVUELVA ESO;
        TipoPrenda camisaCorta = new TipoCamisaCorta(Material.ALGODON);
        Prenda prenda = new Prenda(camisaCorta,camisaCorta.getMaterial(), Arrays.asList(Color.BLACK, Color.RED));
        guardarropa.setPrendas(Arrays.asList(prenda));
        Assert.assertEquals(guardarropa.getPrendas().get(0).getCategoria(), Categoria.SUPERIOR);
    }

    @Test
    public void crearPrendaValida() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        Prenda remera = new Prenda(tipoRemeraCorta, Material.ALGODON, Collections.singletonList(Color.BLACK));
        Assert.assertEquals(remera.getCategoria(), Categoria.SUPERIOR);
    }

    @Test(expected = PrendaNoValidaException.class)
    public void crearPrendaNoValida() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        Prenda remera = new Prenda(tipoRemeraCorta, Material.CUERO, Collections.singletonList(Color.BLACK));
    }
}
