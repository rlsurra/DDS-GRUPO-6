package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.exceptions.ColorPrimarioIgualAlSecundarioException;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;
import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.PuntajePrenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class PrendaTest {

    @Test
    public void saberTipoDePrenda() {
        Material algodon = new Material();
        TipoPrenda tipoRemeraCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        tipoRemeraCorta.getMaterialesPermitidos().add(algodon);
        Prenda remera = new Prenda(tipoRemeraCorta, algodon,"0|0|0|1", "0|0|255|1");
        Assert.assertEquals(tipoRemeraCorta, remera.getTipoPrenda());
    }

    @Test
    public void saberCategoria() {
        Material algodon = new Material();
        TipoPrenda tipoRemeraCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        tipoRemeraCorta.getMaterialesPermitidos().add(algodon);
        Prenda remera = new Prenda("", tipoRemeraCorta, algodon, "0|0|0|1");
        Assert.assertEquals(remera.getCategoria(), CategoriaSuperior.getInstance());
    }

    @Test(expected = ColorPrimarioIgualAlSecundarioException.class)
    public void crearPrendaNoValidaPorColoresIguales() {
        Material algodon = new Material();
        TipoPrenda tipoRemeraCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        tipoRemeraCorta.getMaterialesPermitidos().add(algodon);
        new Prenda(tipoRemeraCorta, algodon, "255|0|0|1", "255|0|0|1");
    }

    @Test
    public void instanciarUsuariosConGuardarropa() {
        GeneradorGuardarropa generadorGuardarropa = new GeneradorGuardarropa();
        generadorGuardarropa.getCasosDePrueba();
    }

    @Test
    public void agregarYActualizarPuntajePrenda(){
        Usuario usuario = new Usuario();
        Usuario usuario2 = new Usuario();
        Material algodon = new Material();
        TipoPrenda tipoRemeraCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        tipoRemeraCorta.getMaterialesPermitidos().add(algodon);
        Prenda remera = new Prenda(tipoRemeraCorta, algodon, "255|0|0|1", "255|0|0|1");

        Assert.assertEquals(0, (int) remera.getPuntajeDeUsuario(usuario));
        Assert.assertEquals(0, (int) remera.getPuntajeDeUsuario(usuario2));

        remera.setPuntaje(usuario, (double) 5);
        remera.setPuntaje(usuario2, (double) 3);

        Assert.assertEquals(5, (int) remera.getPuntajeDeUsuario(usuario));
        Assert.assertEquals(3, (int) remera.getPuntajeDeUsuario(usuario2));

        remera.setPuntaje(usuario, (double) 3);
        remera.setPuntaje(usuario, (double) 4);
        Assert.assertEquals(4, (int) remera.getPuntajeDeUsuario(usuario));
    }

}
