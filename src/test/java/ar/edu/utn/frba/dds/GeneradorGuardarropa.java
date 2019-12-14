package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.categoria.CategoriaAccesorio;
import ar.edu.utn.frba.dds.model.categoria.CategoriaCalzado;
import ar.edu.utn.frba.dds.model.categoria.CategoriaInferior;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoLigero;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.*;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Caluroso;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Friolento;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioPremium;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GeneradorGuardarropa {

    public List<Usuario> getCasosDePrueba() {
        List<Usuario> usuarios = new ArrayList<>();

        Material ALGODON = new Material("ALGODON");
        Material NYLON = new Material("NYLON");
        Material JEAN = new Material("JEAN");
        Material CUERO = new Material("CUERO");
        Material METAL = new Material("METAL");
        Material LANA = new Material("LANA");
        Material GABARDINA = new Material("GABARDINA");
        Material LONA = new Material("LONA");
        Material PLASTICO = new Material("PLASTICO");

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


        TipoPrenda tipoCamisaLarga = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        tipoCamisaLarga.getMaterialesPermitidos().add(ALGODON);
        TipoPrenda tipoRemeraCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        tipoRemeraCorta.getMaterialesPermitidos().add(ALGODON);
        tipoRemeraCorta.getMaterialesPermitidos().add(NYLON);
        TipoPrenda tipoJean = new TipoPrendaInferior(CategoriaInferior.getInstance());
        tipoJean.getMaterialesPermitidos().add(JEAN);
        TipoPrenda tipoBermuda = new TipoPrendaInferior(CategoriaInferior.getInstance());
        tipoBermuda.getMaterialesPermitidos().add(GABARDINA);
        TipoPrenda tipoZapatilla = new TipoPrendaCalzado(CategoriaCalzado.getInstance());
        tipoZapatilla.getMaterialesPermitidos().add(CUERO);
        tipoZapatilla.getMaterialesPermitidos().add(LONA);
        TipoPrenda tipoZapato = new TipoPrendaCalzado(CategoriaCalzado.getInstance());
        tipoZapato.getMaterialesPermitidos().add(CUERO);
        TipoPrenda tipoReloj = new TipoPrendaAccesorio(CategoriaAccesorio.getInstance());
        tipoReloj.getMaterialesPermitidos().add(METAL);
        tipoReloj.getMaterialesPermitidos().add(PLASTICO);
        TipoPrenda tipoGorra = new TipoPrendaAccesorio(CategoriaAccesorio.getInstance());
        tipoGorra.getMaterialesPermitidos().add(ALGODON);
        TipoPrenda tipoCampera = new TipoPrendaInferior(CategoriaInferior.getInstance());
        tipoCampera.getMaterialesPermitidos().add(CUERO);
        TipoPrenda tipoBuzoPolar = new TipoPrendaInferior(CategoriaInferior.getInstance());
        tipoBuzoPolar.getMaterialesPermitidos().add(LANA);
        TipoPrenda tipoBuzo = new TipoPrendaInferior(CategoriaSuperiorAbrigoPesado.getInstance());
        tipoBuzo.getMaterialesPermitidos().add(LANA);
        TipoPrenda tipoSweater = new TipoPrendaInferior(CategoriaSuperiorAbrigoLigero.getInstance());
        tipoSweater.getMaterialesPermitidos().add(LANA);


        // guardarropa pablo 1
        Prenda remeraPablo1 = new Prenda(tipoRemeraCorta, ALGODON, Color.RED, Color.BLACK);
        Prenda remeraPablo2 = new Prenda(tipoRemeraCorta, NYLON, Color.RED, Color.BLUE);
        Prenda jeanPablo1 = new Prenda(tipoJean, JEAN, Color.RED, Color.BLUE);
        Prenda zapatillaPablo1 = new Prenda(tipoZapatilla, CUERO, Color.RED, Color.BLUE);
        Prenda relojPablo1 = new Prenda(tipoReloj, METAL, Color.RED, Color.BLUE);

        List<Prenda> prendasPablo1 = new ArrayList<Prenda>();
        prendasPablo1.add(remeraPablo1);
        prendasPablo1.add(remeraPablo2);
        prendasPablo1.add(jeanPablo1);
        prendasPablo1.add(zapatillaPablo1);
        prendasPablo1.add(relojPablo1);
        guardarropaPablo1.setPrendas(prendasPablo1);

        // guardarropa pablo2

        Prenda remeraPablo3 = new Prenda(tipoRemeraCorta, NYLON, Color.WHITE, Color.BLACK);
        Prenda camisaPablo = new Prenda(tipoCamisaLarga, ALGODON, Color.WHITE, Color.BLACK);
        Prenda camperaPablo = new Prenda(tipoCampera, CUERO, Color.BLACK);
        Prenda buzoPolarPablo = new Prenda(tipoBuzoPolar, LANA, Color.RED);
        Prenda buzoPablo = new Prenda(tipoBuzo, LANA, Color.BLUE);
        Prenda jeanPablo2 = new Prenda(tipoJean, JEAN, Color.RED, Color.BLUE);
        Prenda bermudaPablo = new Prenda(tipoBermuda, GABARDINA, Color.WHITE, Color.BLACK);
        Prenda zapatoPablo = new Prenda(tipoZapato, CUERO, Color.WHITE, Color.BLACK);

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
        Prenda remeraPedro = new Prenda(tipoRemeraCorta, ALGODON, Color.RED, Color.BLUE);
        Prenda jeanPedro = new Prenda(tipoJean, JEAN, Color.RED, Color.BLUE);
        Prenda bermudaPedro = new Prenda(tipoBermuda, GABARDINA, Color.WHITE, Color.BLACK);
        Prenda zapatillaPedro = new Prenda(tipoZapatilla, LONA, Color.RED, Color.BLUE);
        Prenda zapatoPedro = new Prenda(tipoZapato, CUERO, Color.WHITE, Color.BLACK);
        Prenda relojPedro = new Prenda(tipoReloj, PLASTICO, Color.RED, Color.BLUE);
        Prenda gorraPedro = new Prenda(tipoGorra, ALGODON, Color.RED, Color.BLUE);
        Prenda sweaterPedro = new Prenda(tipoSweater, LANA, Color.GRAY);

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
