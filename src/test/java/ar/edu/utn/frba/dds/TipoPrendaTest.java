package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.Categoria;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoAnteojos;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapatilla;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoJean;
import ar.edu.utn.frba.dds.model.prenda.superior.*;
import com.hackerrank.test.utility.Order;
import com.hackerrank.test.utility.OrderedTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(OrderedTestRunner.class)
public class TipoPrendaTest {

    @Test
    @Order(1)
    public void crearTiposDePrendasParaMismaCategoria(){
        TipoPrenda camisaLarga = new TipoCamisaLarga(Material.ALGODON);
        TipoPrenda camisaCorta = new TipoCamisaCorta(Material.ALGODON);
        TipoPrenda chomba = new TipoChomba(Material.ALGODON);
        TipoPrenda musculosa = new TipoMusculosa(Material.ALGODON);
        TipoPrenda remeraCorta = new TipoRemeraCorta(Material.ALGODON);
        TipoPrenda remeraLarga = new TipoRemeraLarga(Material.ALGODON);

        Assert.assertEquals(Categoria.SUPERIOR, camisaLarga.getCategoria());
        Assert.assertEquals(Categoria.SUPERIOR, camisaCorta.getCategoria());
        Assert.assertEquals(Categoria.SUPERIOR, chomba.getCategoria());
        Assert.assertEquals(Categoria.SUPERIOR, musculosa.getCategoria());
        Assert.assertEquals(Categoria.SUPERIOR, remeraCorta.getCategoria());
        Assert.assertEquals(Categoria.SUPERIOR, remeraLarga.getCategoria());
    }

    @Test
    @Order(2)
    public void crearTiposDePrendasParaDistintasCategorias(){
        TipoPrenda camisaLarga = new TipoCamisaLarga(Material.ALGODON);
        TipoPrenda jean = new TipoJean(Material.ALGODON);
        TipoPrenda zapatilla = new TipoZapatilla(Material.ALGODON);
        TipoPrenda anteojos = new TipoAnteojos(Material.ALGODON);

        Assert.assertEquals(Categoria.SUPERIOR, camisaLarga.getCategoria());
        Assert.assertEquals(Categoria.INFERIOR, jean.getCategoria());
        Assert.assertEquals(Categoria.CALZADO, zapatilla.getCategoria());
        Assert.assertEquals(Categoria.ACCESORIO, anteojos.getCategoria());
    }

    @Test
    public void toStringTest(){
        TipoPrenda camisaLarga = new TipoCamisaLarga(Material.ALGODON);
        System.out.println(camisaLarga.toString());
    }
}
