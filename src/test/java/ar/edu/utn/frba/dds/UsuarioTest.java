package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.exceptions.MaximaCantidadPrendasException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.model.Evento;
import ar.edu.utn.frba.dds.model.Guardarropa;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.Prenda;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoOjota;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapatilla;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapato;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoBermuda;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoJean;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoJogging;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoCamisaCorta;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoChomba;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoRemeraCorta;
import ar.edu.utn.frba.dds.model.usuario.TipoUsuarioGratuito;
import ar.edu.utn.frba.dds.model.usuario.TipoUsuarioPremium;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class UsuarioTest {
    private Guardarropa guardarropa1 = new Guardarropa();
    private Guardarropa guardarropa2 = new Guardarropa();

    private Evento evento1 = new Evento("Buenos Aires", LocalDateTime.of(2019, 7, 22, 10, 0));
    private Evento evento2 = new Evento("Rio de Janeiro", LocalDateTime.of(2019, 8, 3, 22, 45));

    @Before
    public void setUp(){
        guardarropa1.setPrendasSuperiores(Arrays.asList(
            new Prenda(new TipoCamisaCorta(), Material.ALGODON, Color.RED),
            new Prenda(new TipoRemeraCorta(), Material.NYLON, Color.BLACK),
            new Prenda(new TipoChomba(), Material.ALGODON, Color.blue)
        ));

        guardarropa2.setPrendasInferiores(Arrays.asList(
                new Prenda(new TipoJean(), Material.JEAN, Color.BLUE),
                new Prenda(new TipoJogging(), Material.ALGODON, Color.BLACK),
                new Prenda(new TipoBermuda(), Material.GABARDINA, Color.GRAY)
        ));

        guardarropa2.setPrendasCalzado(Arrays.asList(
                new Prenda(new TipoZapatilla(), Material.LONA, Color.BLACK),
                new Prenda(new TipoZapato(), Material.CUERO, Color.BLACK),
                new Prenda(new TipoOjota(), Material.CAUCHO, Color.GREEN)
        ));

    }

    @Test (expected = ParametrosInvalidosException.class)
    public void crearUsuarioError(){
        new Usuario(null);
    }

    @Test
    public void crearUsuarioGratuitoExitoso(){
        Usuario usuario = new Usuario(new TipoUsuarioGratuito());
        usuario.agregarGuardarropa(guardarropa1);
        usuario.agregarEvento(evento1);
    }


    @Test (expected = MaximaCantidadPrendasException.class)
    public void crearUsuarioGratuitoError(){
        Usuario usuario = new Usuario(new TipoUsuarioGratuito());
        usuario.agregarGuardarropa(guardarropa2);
        usuario.agregarEvento(evento1);
    }

    @Test
    public void crearUsuarioPremiumExitoso(){
        Usuario usuario = new Usuario(new TipoUsuarioPremium());
        usuario.agregarGuardarropa(guardarropa2);
        usuario.agregarEvento(evento2);
    }


}
