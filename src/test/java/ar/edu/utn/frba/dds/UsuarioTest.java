package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.exceptions.MaximaCantidadPrendasException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.model.categoria.CategoriaCalzado;
import ar.edu.utn.frba.dds.model.categoria.CategoriaInferior;
import ar.edu.utn.frba.dds.model.categoria.CategoriaSuperior;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.evento.EventoSimple;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaCalzado;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaInferior;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Caluroso;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Friolento;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Normal;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioGratuito;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioPremium;
import org.junit.Test;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class UsuarioTest {
//    private Guardarropa guardarropa1 = new Guardarropa();
//    private Guardarropa guardarropa2 = new Guardarropa();

    private Guardarropa guardarropa1;
    private Guardarropa guardarropa2;

    private Evento evento1 = new EventoSimple(1, LocalDateTime.of(2019, 7, 22, 10, 0));
    private Evento evento2 = new EventoSimple(2, LocalDateTime.of(2019, 8, 3, 22, 45));

    //    @Before
    public void setUp() {
        Material ALGODON = new Material("ALGODON");
        Material NYLON = new Material("NYLON");
        Material JEAN = new Material("JEAN");
        Material GABARDINA = new Material("GABARDINA");
        Material LONA = new Material("LONA");
        Material CUERO = new Material("CUERO");
        Material CAUCHO = new Material("CAUCHO");

        TipoPrendaSuperior TipoCamisaCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        TipoCamisaCorta.getMaterialesPermitidos().add(ALGODON);

        TipoPrendaSuperior TipoRemeraCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        TipoRemeraCorta.getMaterialesPermitidos().add(NYLON);

        TipoPrendaSuperior TipoChomba = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        TipoChomba.getMaterialesPermitidos().add(ALGODON);

        TipoPrendaInferior TipoJean = new TipoPrendaInferior(CategoriaInferior.getInstance());
        TipoJean.getMaterialesPermitidos().add(JEAN);

        TipoPrendaInferior TipoJogging = new TipoPrendaInferior(CategoriaInferior.getInstance());
        TipoJogging.getMaterialesPermitidos().add(ALGODON);

        TipoPrendaInferior TipoBermuda = new TipoPrendaInferior(CategoriaInferior.getInstance());
        TipoBermuda.getMaterialesPermitidos().add(GABARDINA);

        TipoPrendaCalzado TipoZapatilla = new TipoPrendaCalzado(CategoriaCalzado.getInstance());
        TipoZapatilla.getMaterialesPermitidos().add(LONA);

        TipoPrendaCalzado TipoZapato = new TipoPrendaCalzado(CategoriaCalzado.getInstance());
        TipoZapato.getMaterialesPermitidos().add(CUERO);

        TipoPrendaCalzado TipoOjota = new TipoPrendaCalzado(CategoriaCalzado.getInstance());
        TipoOjota.getMaterialesPermitidos().add(CAUCHO);

        guardarropa1.setPrendas(Arrays.asList(
                new Prenda("", TipoCamisaCorta, ALGODON, Color.RED),
                new Prenda("", TipoRemeraCorta, NYLON, Color.BLACK),
                new Prenda("", TipoChomba, ALGODON, Color.blue)
        ));

        guardarropa2.setPrendas(Arrays.asList(
                new Prenda("", TipoJean, JEAN, Color.BLUE),
                new Prenda("", TipoJogging, ALGODON, Color.BLACK),
                new Prenda("", TipoBermuda, GABARDINA, Color.GRAY),
                new Prenda("", TipoZapatilla, LONA, Color.BLACK),
                new Prenda("", TipoZapato, CUERO, Color.BLACK),
                new Prenda("", TipoOjota, CAUCHO, Color.GREEN)
        ));

    }

    @Test(expected = ParametrosInvalidosException.class)
    public void crearUsuarioError() {
        new Usuario(null, null);
    }

    @Test
    public void crearUsuarioGratuitoExitoso() {
        Usuario usuario = new Usuario(new TipoUsuarioGratuito(), new Caluroso());
        guardarropa1 = new Guardarropa(usuario);
        guardarropa2 = new Guardarropa(usuario);
        setUp();

        usuario.agregarGuardarropa(guardarropa1);
        usuario.agregarEvento(evento1);
    }


    @Test(expected = MaximaCantidadPrendasException.class)
    public void crearUsuarioGratuitoError() {
        Usuario usuario = new Usuario(new TipoUsuarioGratuito(), new Friolento());
        guardarropa1 = new Guardarropa(usuario);
        guardarropa2 = new Guardarropa(usuario);
        setUp();

        usuario.agregarGuardarropa(guardarropa2);
        usuario.agregarEvento(evento1);
    }

    @Test
    public void crearUsuarioPremiumExitoso() {
        Usuario usuario = new Usuario(new TipoUsuarioPremium(), new Normal());
        guardarropa1 = new Guardarropa(usuario);
        guardarropa2 = new Guardarropa(usuario);
        setUp();

        usuario.agregarGuardarropa(guardarropa2);
        usuario.agregarEvento(evento2);
    }


}
