package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.*;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoAnteojos;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoReloj;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapatilla;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapato;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoBermuda;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoJean;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoCamisaCorta;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoCamisaLarga;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoRemeraCorta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GuardarropaTest {

    private Guardarropa guardarropa;
    private GeneradorDeAtuendos generadorDeAtuendos = GeneradorDeAtuendos.getInstance();
    private List<Prenda> prendas;
    private List<Prenda> prendasBasicas;
    private List<Prenda> prendasSinAccesorio;

    @Before
    public void setUp(){
        guardarropa = new Guardarropa();
        Usuario user = new Usuario();

        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        Prenda remeraCorta = new Prenda(tipoRemeraCorta, tipoRemeraCorta.getMaterial(), Collections.singletonList(Color.BLACK));
        TipoPrenda tipoCamisaLarga = new TipoCamisaLarga(Material.ALGODON);
        Prenda camisaLarga = new Prenda(tipoCamisaLarga, tipoCamisaLarga.getMaterial(), Collections.singletonList(Color.BLACK));
        TipoPrenda tipoJean = new TipoJean(Material.ALGODON);
        Prenda jean = new Prenda(tipoJean, tipoJean.getMaterial(), Collections.singletonList(Color.BLACK));
        TipoPrenda tipoBermuda = new TipoBermuda(Material.ALGODON);
        Prenda bermuda = new Prenda(tipoBermuda, tipoBermuda.getMaterial(), Collections.singletonList(Color.BLACK));
        TipoPrenda tipoZapatilla = new TipoZapatilla(Material.PLASTICO);
        Prenda zapatilla = new Prenda(tipoZapatilla, tipoZapatilla.getMaterial(), Collections.singletonList(Color.BLACK));
        TipoPrenda tipoZapatillaCuero = new TipoZapatilla(Material.CUERO);
        Prenda zapatillaCuero = new Prenda(tipoZapatillaCuero, tipoZapatillaCuero.getMaterial(), Collections.singletonList(Color.BLACK));
        TipoPrenda tipoZapato = new TipoZapato(Material.CUERO);
        Prenda zapato = new Prenda(tipoZapato, tipoZapato.getMaterial(), Collections.singletonList(Color.BLACK));
        TipoPrenda tipoReloj = new TipoReloj(Material.METAL);
        Prenda reloj = new Prenda(tipoReloj, tipoReloj.getMaterial(), Collections.singletonList(Color.BLACK));
        TipoPrenda tipoAnteojos = new TipoAnteojos(Material.METAL);
        Prenda anteojos = new Prenda(tipoAnteojos, tipoAnteojos.getMaterial(), Collections.singletonList(Color.BLACK));

        prendas = Arrays.asList(remeraCorta, camisaLarga, jean, bermuda, zapatilla, zapatillaCuero, zapato, reloj, anteojos);
        prendasBasicas = Arrays.asList(remeraCorta, camisaLarga, jean, zapatilla, reloj);
        prendasSinAccesorio = Arrays.asList(remeraCorta, camisaLarga, jean, zapatilla);

    }

    @Test
    public void guardarPrendaEnUnGuardarropa() {
        //CREAR UNA REMERA DEL TIPO CORTA Y CATEGORIA SUPEROR, QUE DEVUELVA ESO;
        TipoPrenda camisaCorta = new TipoCamisaCorta(Material.ALGODON);
        Prenda prenda = new Prenda(camisaCorta,camisaCorta.getMaterial(), Arrays.asList(Color.BLACK, Color.RED));
        guardarropa.setPrendas(Collections.singletonList(prenda));
        Assert.assertEquals(guardarropa.getPrendas().get(0).getCategoria(), Categoria.SUPERIOR);
    }


    @Test
    public void generarAtuendoTest(){
        List<Atuendo> atuendos = generadorDeAtuendos.generarAtuendos(prendasSinAccesorio);
        System.out.println(atuendos);
    }


}
