package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.GrupoUsuario;
import ar.edu.utn.frba.dds.model.Guardarropa;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.Prenda;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoGorra;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoReloj;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapatilla;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapato;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoBermuda;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoJean;
import ar.edu.utn.frba.dds.model.prenda.superior.abrigoLigero.TipoBuzo;
import ar.edu.utn.frba.dds.model.prenda.superior.abrigoLigero.TipoSweater;
import ar.edu.utn.frba.dds.model.prenda.superior.abrigoPesado.TipoBuzoPolar;
import ar.edu.utn.frba.dds.model.prenda.superior.abrigoPesado.TipoCampera;
import ar.edu.utn.frba.dds.model.prenda.superior.camisa.TipoCamisaLarga;
import ar.edu.utn.frba.dds.model.prenda.superior.remera.TipoRemeraCorta;
import ar.edu.utn.frba.dds.model.usuario.TipoUsuarioPremium;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Caluroso;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Friolento;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneradorGuardarropa {

    public List<Usuario> getCasosDePrueba() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario pablo = new Usuario(new TipoUsuarioPremium(), new Caluroso());
        Usuario pedro = new Usuario(new TipoUsuarioPremium(), new Friolento());
        Guardarropa guardarropaPablo1 = new Guardarropa();
        Guardarropa guardarropaPablo2 = new Guardarropa();
        Guardarropa guardarropaPedro = new Guardarropa();

        pablo.agregarGuardarropa(guardarropaPablo1);
        pablo.agregarGuardarropa(guardarropaPablo2);
        pedro.agregarGuardarropa(guardarropaPedro);

        GrupoUsuario testGrupo = new GrupoUsuario("testGrupo");
        testGrupo.setUsuarios(Arrays.asList(pablo, pedro));


        TipoPrenda tipoCamisaLarga = new TipoCamisaLarga();
        TipoPrenda tipoRemeraCorta = new TipoRemeraCorta();
        TipoPrenda tipoJean = new TipoJean();
        TipoPrenda tipoBermuda = new TipoBermuda();
        TipoPrenda tipoZapatilla = new TipoZapatilla();
        TipoPrenda tipoZapato = new TipoZapato();
        TipoPrenda tipoReloj = new TipoReloj();
        TipoPrenda tipoGorra = new TipoGorra();
        TipoPrenda tipoCampera = new TipoCampera();
        TipoPrenda tipoBuzoPolar = new TipoBuzoPolar();
        TipoPrenda tipoBuzo = new TipoBuzo();
        TipoPrenda tipoSweater = new TipoSweater();


        // guardarropa pablo 1
        Prenda remeraPablo1 = new Prenda(tipoRemeraCorta, Material.ALGODON, Color.RED, Color.BLACK);
        Prenda remeraPablo2 = new Prenda(tipoRemeraCorta, Material.NYLON, Color.RED, Color.BLUE);
        Prenda jeanPablo1 = new Prenda(tipoJean, Material.JEAN, Color.RED, Color.BLUE);
        Prenda zapatillaPablo1 = new Prenda(tipoZapatilla, Material.CUERO, Color.RED, Color.BLUE);
        Prenda relojPablo1 = new Prenda(tipoReloj, Material.METAL, Color.RED, Color.BLUE);


        guardarropaPablo1.setPrendasSuperiores(Arrays.asList(remeraPablo1, remeraPablo2));
        guardarropaPablo1.setPrendasInferiores(Arrays.asList(jeanPablo1));
        guardarropaPablo1.setPrendasCalzado(Arrays.asList(zapatillaPablo1));
        guardarropaPablo1.setPrendasAccesorio(Arrays.asList(relojPablo1));


        // guardarropa pablo2
        Prenda remeraPablo3 = new Prenda(tipoRemeraCorta, Material.NYLON, Color.WHITE,Color.BLACK);
        Prenda camisaPablo = new Prenda(tipoCamisaLarga, Material.ALGODON, Color.WHITE,Color.BLACK);
        guardarropaPablo2.setPrendasSuperiores(Arrays.asList(remeraPablo3, camisaPablo));

        Prenda camperaPablo = new Prenda(tipoCampera, Material.CUERO, Color.BLACK);
        Prenda buzoPolarPablo = new Prenda(tipoBuzoPolar, Material.LANA, Color.RED);
        guardarropaPablo2.setPrendasAbrigoPesado(Arrays.asList(camperaPablo, buzoPolarPablo));

        Prenda buzoPablo = new Prenda(tipoBuzo, Material.LANA, Color.BLUE);
        guardarropaPablo2.setPrendasAbrigoLigero(Arrays.asList(buzoPablo));

        Prenda jeanPablo2 = new Prenda(tipoJean, Material.JEAN, Color.RED,Color.BLUE);
        Prenda bermudaPablo = new Prenda(tipoBermuda, Material.GABARDINA, Color.WHITE,Color.BLACK);
        guardarropaPablo2.setPrendasInferiores(Arrays.asList(jeanPablo2, bermudaPablo));

        Prenda zapatoPablo = new Prenda(tipoZapato, Material.CUERO, Color.WHITE,Color.BLACK);
        guardarropaPablo2.setPrendasCalzado(Arrays.asList(zapatoPablo));

        // guardarropa pedro
        Prenda remeraPedro = new Prenda(tipoRemeraCorta, Material.ALGODON, Color.RED,Color.BLUE);
        guardarropaPedro.setPrendasSuperiores(Arrays.asList(remeraPedro));

        Prenda jeanPedro = new Prenda(tipoJean, Material.JEAN, Color.RED,Color.BLUE);
        Prenda bermudaPedro = new Prenda(tipoBermuda, Material.GABARDINA, Color.WHITE,Color.BLACK);
        guardarropaPedro.setPrendasInferiores(Arrays.asList(jeanPedro, bermudaPedro));

        Prenda zapatillaPedro = new Prenda(tipoZapatilla, Material.LONA, Color.RED,Color.BLUE);
        Prenda zapatoPedro = new Prenda(tipoZapato, Material.CUERO, Color.WHITE,Color.BLACK);
        guardarropaPedro.setPrendasCalzado(Arrays.asList(zapatillaPedro, zapatoPedro));

        Prenda relojPedro = new Prenda(tipoReloj, Material.PLASTICO, Color.RED,Color.BLUE);
        Prenda gorraPedro = new Prenda(tipoGorra, Material.ALGODON, Color.RED,Color.BLUE);
        guardarropaPedro.setPrendasAccesorio(Arrays.asList(relojPedro, gorraPedro));

        Prenda sweaterPedro = new Prenda(tipoSweater, Material.LANA, Color.GRAY);
        guardarropaPedro.setPrendasAbrigoLigero(Arrays.asList(sweaterPedro));


        usuarios.add(pablo);
        usuarios.add(pedro);
        return usuarios;
    }

}
