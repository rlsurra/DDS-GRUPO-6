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
import ar.edu.utn.frba.dds.model.prenda.superior.*;

import java.awt.*;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

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

        TipoPrenda tipoCamisaLarga = new TipoCamisaLarga(Material.ALGODON);
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta(Material.ALGODON);
        TipoPrenda tipoJean = new TipoJean(Material.ALGODON);
        TipoPrenda tipoBermuda = new TipoBermuda(Material.ALGODON);
        TipoPrenda tipoZapatilla = new TipoZapatilla(Material.LONA);
        TipoPrenda tipoZapato = new TipoZapato(Material.CUERO);
        TipoPrenda tipoReloj = new TipoReloj(Material.METAL);
        TipoPrenda tipoGorra = new TipoGorra(Material.ALGODON);

        Prenda remeraPablo1 = new Prenda(tipoRemeraCorta, tipoRemeraCorta.getMaterial(), Arrays.asList(Color.RED,Color.BLACK));
        Prenda remeraPablo2 = new Prenda(tipoRemeraCorta, tipoRemeraCorta.getMaterial(), Arrays.asList(Color.RED,Color.BLUE));
        Prenda jeanPablo1 = new Prenda(tipoJean, tipoJean.getMaterial(), Arrays.asList(Color.RED,Color.BLUE));
        Prenda zapatillaPablo1 = new Prenda(tipoZapatilla, tipoZapatilla.getMaterial(), Arrays.asList(Color.RED,Color.BLUE));
        Prenda relojPablo1 = new Prenda(tipoReloj, tipoReloj.getMaterial(), Arrays.asList(Color.RED,Color.BLUE));
        guardarropaPablo1.setPrendas(Arrays.asList(remeraPablo1, remeraPablo2, jeanPablo1, zapatillaPablo1, relojPablo1));

        Prenda remeraPablo3 = new Prenda(tipoRemeraCorta, tipoRemeraCorta.getMaterial(), Arrays.asList(Color.WHITE,Color.BLACK));
        Prenda camisaPablo = new Prenda(tipoCamisaLarga, tipoCamisaLarga.getMaterial(), Arrays.asList(Color.WHITE,Color.BLACK));
        Prenda jeanPablo2 = new Prenda(tipoJean, tipoJean.getMaterial(), Arrays.asList(Color.RED,Color.BLUE));
        Prenda bermudaPablo = new Prenda(tipoBermuda, tipoBermuda.getMaterial(), Arrays.asList(Color.WHITE,Color.BLACK));
        Prenda zapatoPablo = new Prenda(tipoZapato, tipoZapato.getMaterial(), Arrays.asList(Color.WHITE,Color.BLACK));
        guardarropaPablo2.setPrendas(Arrays.asList(remeraPablo3, camisaPablo, jeanPablo2, bermudaPablo, zapatoPablo));

        Prenda remeraPedro = new Prenda(tipoRemeraCorta, tipoRemeraCorta.getMaterial(), Arrays.asList(Color.RED,Color.BLUE));
        Prenda jeanPedro = new Prenda(tipoJean, tipoJean.getMaterial(), Arrays.asList(Color.RED,Color.BLUE));
        Prenda bermudaPedro = new Prenda(tipoBermuda, tipoBermuda.getMaterial(), Arrays.asList(Color.WHITE,Color.BLACK));
        Prenda zapatillaPedro = new Prenda(tipoZapatilla, tipoZapatilla.getMaterial(), Arrays.asList(Color.RED,Color.BLUE));
        Prenda zapatoPedro = new Prenda(tipoZapato, tipoZapato.getMaterial(), Arrays.asList(Color.WHITE,Color.BLACK));
        Prenda relojPedro = new Prenda(tipoReloj, tipoReloj.getMaterial(), Arrays.asList(Color.RED,Color.BLUE));
        Prenda gorraPedro = new Prenda(tipoGorra, tipoGorra.getMaterial(), Arrays.asList(Color.RED,Color.BLUE));
        guardarropaPedro.setPrendas(Arrays.asList(remeraPedro, jeanPedro, bermudaPedro, zapatillaPedro, zapatoPedro, relojPedro, gorraPedro));


        System.out.println("Pablo le pide a sus guardarropas que ponerse : ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(pablo.queMePongo());
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(System.getProperty("line.separator"));
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Pablo le pide a sus guardarropas que ponerse : ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(pedro.queMePongo());

    }
}
