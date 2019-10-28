package ar.edu.utn.frba.dds;

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
        Guardarropa guardarropaPablo1 = new Guardarropa(pablo);
        Guardarropa guardarropaPablo2 = new Guardarropa(pablo);
        Guardarropa guardarropaPedro = new Guardarropa(pedro);

        pablo.agregarGuardarropa(guardarropaPablo1);
        pablo.agregarGuardarropa(guardarropaPablo2);
        pedro.agregarGuardarropa(guardarropaPedro);

        guardarropaPablo1.setPropietario(pablo);
        guardarropaPablo2.setPropietario(pablo);
        guardarropaPedro.setPropietario(pedro);
        guardarropaPedro.agregarUsuario(pedro);
        guardarropaPedro.agregarUsuario(pablo);


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

        List<Prenda> prendasPablo1 = new ArrayList<Prenda>();
        prendasPablo1.add(remeraPablo1);
        prendasPablo1.add(remeraPablo2);
        prendasPablo1.add(jeanPablo1);
        prendasPablo1.add(zapatillaPablo1);
        prendasPablo1.add(relojPablo1);
        guardarropaPablo1.setPrendas(prendasPablo1);

        // guardarropa pablo2

        Prenda remeraPablo3 = new Prenda(tipoRemeraCorta, Material.NYLON, Color.WHITE, Color.BLACK);
        Prenda camisaPablo = new Prenda(tipoCamisaLarga, Material.ALGODON, Color.WHITE, Color.BLACK);
        Prenda camperaPablo = new Prenda(tipoCampera, Material.CUERO, Color.BLACK);
        Prenda buzoPolarPablo = new Prenda(tipoBuzoPolar, Material.LANA, Color.RED);
        Prenda buzoPablo = new Prenda(tipoBuzo, Material.LANA, Color.BLUE);
        Prenda jeanPablo2 = new Prenda(tipoJean, Material.JEAN, Color.RED, Color.BLUE);
        Prenda bermudaPablo = new Prenda(tipoBermuda, Material.GABARDINA, Color.WHITE, Color.BLACK);
        Prenda zapatoPablo = new Prenda(tipoZapato, Material.CUERO, Color.WHITE, Color.BLACK);

        List<Prenda> prendasPablo2 = new ArrayList<>();
        prendasPablo2.add(remeraPablo3);
        prendasPablo2.add(camisaPablo);
        prendasPablo2.add(camperaPablo);
        prendasPablo2.add(buzoPolarPablo);
        prendasPablo2.add(buzoPablo);
        prendasPablo2.add(jeanPablo2);
        prendasPablo2.add(bermudaPablo);
        prendasPablo2.add(zapatoPablo);
        guardarropaPablo1.setPrendas(prendasPablo2);

        // Guardarropa pedro
        Prenda remeraPedro = new Prenda(tipoRemeraCorta, Material.ALGODON, Color.RED, Color.BLUE);
        Prenda jeanPedro = new Prenda(tipoJean, Material.JEAN, Color.RED, Color.BLUE);
        Prenda bermudaPedro = new Prenda(tipoBermuda, Material.GABARDINA, Color.WHITE, Color.BLACK);
        Prenda zapatillaPedro = new Prenda(tipoZapatilla, Material.LONA, Color.RED, Color.BLUE);
        Prenda zapatoPedro = new Prenda(tipoZapato, Material.CUERO, Color.WHITE, Color.BLACK);
        Prenda relojPedro = new Prenda(tipoReloj, Material.PLASTICO, Color.RED, Color.BLUE);
        Prenda gorraPedro = new Prenda(tipoGorra, Material.ALGODON, Color.RED, Color.BLUE);
        Prenda sweaterPedro = new Prenda(tipoSweater, Material.LANA, Color.GRAY);

        List<Prenda> prendasPedro = new ArrayList<>();
        prendasPedro.add(sweaterPedro);
        prendasPedro.add(relojPedro);
        prendasPedro.add(gorraPedro);
        prendasPedro.add(zapatillaPedro);
        prendasPedro.add(zapatoPedro);
        prendasPedro.add(jeanPedro);
        prendasPedro.add(bermudaPedro);
        prendasPedro.add(remeraPedro);
        guardarropaPedro.setPrendas(prendasPedro);

        usuarios.add(pablo);
        usuarios.add(pedro);
        return usuarios;
    }

}
