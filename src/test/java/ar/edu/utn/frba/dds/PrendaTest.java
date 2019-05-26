package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.Categoria;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.Prenda;
import ar.edu.utn.frba.dds.exceptions.PrendaNoValidaException;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoRemeraCorta;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class PrendaTest {

    //Debe saberse que tipo de prenda es
    @Test
    public void getTipoDePrenda() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        Prenda remera = new Prenda(tipoRemeraCorta, Material.ALGODON, Collections.singletonList(Color.BLACK));
        Assert.assertEquals(tipoRemeraCorta, remera.getTipoPrenda());
    }

    //Debe saberse a que categoria pertenece, la cual debe ser consistente con el tipo de prenda y parte del cuerpo
    // ---- Con la forma en la que esta modelado, no puede definirse la categoria de la prenda, ya viene establecida
    // ---- segun el tipo de prenda que se inicialize
    @Test
    public void getCategoria() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        Prenda remera = new Prenda(tipoRemeraCorta, Material.ALGODON, Collections.singletonList(Color.BLACK));
        Assert.assertEquals(remera.getCategoria(), Categoria.SUPERIOR);
    }

    //debe ser de un tipo de tela que debe ser consistente con el tipo de prenda
    // --- Actualmente, en nuestro modelo, la validacion se hace al crear la prenda y no al crear el tipo de prenda
    @Test
    public void crearPrendaValidaPorMaterial() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        Prenda remera = new Prenda(tipoRemeraCorta, Material.ALGODON, Collections.singletonList(Color.BLACK));
        Assert.assertEquals(remera.getCategoria(), Categoria.SUPERIOR);
    }

    @Test(expected = PrendaNoValidaException.class)
    public void crearPrendaNoValidaPorMaterial() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        new Prenda(tipoRemeraCorta, Material.CUERO, Collections.singletonList(Color.BLACK));
    }

    @Test
    public void crearPrendaValidaPorColores() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        Prenda remera = new Prenda(tipoRemeraCorta, Material.ALGODON, Arrays.asList(Color.RED,Color.BLACK));
        Assert.assertEquals(Arrays.asList(Color.RED,Color.BLACK), remera.getColores());
    }

    @Test(expected = PrendaNoValidaException.class)
    public void crearPrendaNoValidaPorColoresIguales() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        new Prenda(tipoRemeraCorta, Material.ALGODON, Arrays.asList(Color.RED,Color.RED));
    }

    @Test(expected = PrendaNoValidaException.class)
    public void crearPrendaNoValidaPorMasDe2Colores() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        new Prenda(tipoRemeraCorta, Material.ALGODON, Arrays.asList(Color.RED,Color.BLACK,Color.BLUE));
    }

    @Test(expected = PrendaNoValidaException.class)
    public void crearPrendaNoValidaPorNoTenerColores() {
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        new Prenda(tipoRemeraCorta, Material.ALGODON, Collections.emptyList());
    }
}
