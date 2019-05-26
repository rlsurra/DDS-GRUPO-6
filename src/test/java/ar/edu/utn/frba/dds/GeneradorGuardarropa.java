package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.Guardarropa;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.Prenda;
import ar.edu.utn.frba.dds.model.Usuario;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoGorra;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoReloj;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapatilla;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapato;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoBermuda;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoJean;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoCamisaLarga;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoRemeraCorta;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GeneradorGuardarropa {


    public List<Usuario> getCasosDePrueba(){

        Usuario pablo = new Usuario();
        Usuario pedro = new Usuario();
        Guardarropa guardarropaPablo1 = new Guardarropa();
        Guardarropa guardarropaPablo2 = new Guardarropa();
        Guardarropa guardarropaPedro = new Guardarropa();

        pablo.agregarGuardarropa(guardarropaPablo1);
        pablo.agregarGuardarropa(guardarropaPablo2);
        pedro.agregarGuardarropa(guardarropaPedro);

        //pablo ----  2 prendas superiores, 1 inferior, 1 calzado, 1 accesorio
        // 4 atuendos posibles
        //pablo ----  2 prendas superiores, 2 inferior, 1 calzado
        // 4 atuendos posibles
        // total 8 atuendos
        //pedro ----  1 prenda superior, 2 inferior, 2 calzado, 2 accesorio
        // 12 prendas posibles


        TipoPrenda tipoCamisaLarga = new TipoCamisaLarga();
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta();
        TipoPrenda tipoJean = new TipoJean();
        TipoPrenda tipoBermuda = new TipoBermuda();
        TipoPrenda tipoZapatilla = new TipoZapatilla();
        TipoPrenda tipoZapato = new TipoZapato();
        TipoPrenda tipoReloj = new TipoReloj();
        TipoPrenda tipoGorra = new TipoGorra();

        Prenda remeraPablo1 = new Prenda(tipoRemeraCorta, Material.ALGODON, Color.RED, Color.BLACK);
        Prenda remeraPablo2 = new Prenda(tipoRemeraCorta, Material.NYLON, Color.RED, Color.BLUE);
        Prenda jeanPablo1 = new Prenda(tipoJean, Material.JEAN, Color.RED,Color.BLUE);
        Prenda zapatillaPablo1 = new Prenda(tipoZapatilla, Material.CUERO, Color.RED,Color.BLUE);
        Prenda relojPablo1 = new Prenda(tipoReloj, Material.METAL, Color.RED,Color.BLUE);
        //guardarropaPablo1.setP(Arrays.asList(remeraPablo1, remeraPablo2, jeanPablo1, zapatillaPablo1, relojPablo1));

        Prenda remeraPablo3 = new Prenda(tipoRemeraCorta, tipoRemeraCorta.getMaterial(), Color.WHITE,Color.BLACK);
        Prenda camisaPablo = new Prenda(tipoCamisaLarga, tipoCamisaLarga.getMaterial(), Color.WHITE,Color.BLACK);
        Prenda jeanPablo2 = new Prenda(tipoJean, tipoJean.getMaterial(), Color.RED,Color.BLUE);
        Prenda bermudaPablo = new Prenda(tipoBermuda, tipoBermuda.getMaterial(), Color.WHITE,Color.BLACK);
        Prenda zapatoPablo = new Prenda(tipoZapato, tipoZapato.getMaterial(), Color.WHITE,Color.BLACK);
        //    guardarropaPablo2.setPrendas(Arrays.asList(remeraPablo3, camisaPablo, jeanPablo2, bermudaPablo, zapatoPablo);

        Prenda remeraPedro = new Prenda(tipoRemeraCorta, tipoRemeraCorta.getMaterial(), Color.RED,Color.BLUE);
        Prenda jeanPedro = new Prenda(tipoJean, tipoJean.getMaterial(), Color.RED,Color.BLUE);
        Prenda bermudaPedro = new Prenda(tipoBermuda, tipoBermuda.getMaterial(), Color.WHITE,Color.BLACK);
        Prenda zapatillaPedro = new Prenda(tipoZapatilla, tipoZapatilla.getMaterial(), Color.RED,Color.BLUE);
        Prenda zapatoPedro = new Prenda(tipoZapato, tipoZapato.getMaterial(), Color.WHITE,Color.BLACK);
        Prenda relojPedro = new Prenda(tipoReloj, tipoReloj.getMaterial(), Color.RED,Color.BLUE);
        Prenda gorraPedro = new Prenda(tipoGorra, tipoGorra.getMaterial(), Color.RED,Color.BLUE);
        //    guardarropaPedro.setPrendas(Arrays.asList(remeraPedro, jeanPedro, bermudaPedro, zapatillaPedro, zapatoPedro, relojPedro, gorraPedro));


    }
}
