package ar.edu.utn.frba.dds;

import java.awt.Color;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    Prenda prenda = new Prenda(TipoPrenda.CAMISA_CORTA,Material.ALGODON, Arrays.asList(Color.BLACK));
    guardarropa.setPrendas(Arrays.asList(prenda));
    Assert.assertEquals(guardarropa.getPrendas().get(0).getCategoria(),Categoria.SUPERIOR);
    }

}
