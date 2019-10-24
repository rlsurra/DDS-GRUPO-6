package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.exceptions.GuardarropaUsuarioException;
import ar.edu.utn.frba.dds.model.Guardarropa;
import ar.edu.utn.frba.dds.model.GuardarropaUsuarioService;
import ar.edu.utn.frba.dds.model.usuario.GuardarropaUsuario;
import ar.edu.utn.frba.dds.model.usuario.TipoUsuarioGratuito;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Caluroso;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GuardarropaUsuarioServiceTest {

    @Test (expected = GuardarropaUsuarioException.class)
    public void agregarRelacionCuandoElUsuarioEsPropietario() {
        Usuario usuario = new Usuario(new TipoUsuarioGratuito(), new Caluroso());
        Guardarropa guardarropa = new Guardarropa(usuario);
        GuardarropaUsuarioService.GuardarropaUsuarioService().agregarRelacion(usuario,guardarropa);
    }

    @Test
    public void agregarUnGuardarropaCompartidoAUsuario() {
        Usuario usuario1 = new Usuario(new TipoUsuarioGratuito(), new Caluroso());
        Guardarropa guardarropa1 = new Guardarropa(usuario1);

        Usuario usuario2 = new Usuario(new TipoUsuarioGratuito(), new Caluroso());
        Guardarropa guardarropa2 = new Guardarropa(usuario2);

        GuardarropaUsuarioService svc = GuardarropaUsuarioService.GuardarropaUsuarioService();
        svc.agregarRelacion(usuario1 ,guardarropa2);
        svc.agregarRelacion(usuario2 ,guardarropa1);

        List<GuardarropaUsuario> usuariosG1 = svc.obtenerUsuariosCompartidosDeGuardarropa(guardarropa1);
        List<GuardarropaUsuario> usuariosG2 = svc.obtenerUsuariosCompartidosDeGuardarropa(guardarropa2);

        Assert.assertEquals(1, usuariosG1.size());
        Assert.assertEquals(usuario2, usuariosG1.get(0).usuario);

        Assert.assertEquals(1, usuariosG2.size());
        Assert.assertEquals(usuario1, usuariosG2.get(0).usuario);
    }

    @Test
    public void agregarMasDeUnGuardarropaCompartidoAUsuario() {
        Usuario usuario1 = new Usuario(new TipoUsuarioGratuito(), new Caluroso());
        Guardarropa guardarropa1 = new Guardarropa(usuario1);

        Usuario usuario2 = new Usuario(new TipoUsuarioGratuito(), new Caluroso());
        Guardarropa guardarropa2 = new Guardarropa(usuario2);
        Guardarropa guardarropa3 = new Guardarropa(usuario2);
        Guardarropa guardarropa4 = new Guardarropa(usuario2);
        Guardarropa guardarropa5 = new Guardarropa(usuario2);

        GuardarropaUsuarioService svc = GuardarropaUsuarioService.GuardarropaUsuarioService();
        svc.agregarRelacion(usuario1 ,guardarropa2);
        svc.agregarRelacion(usuario1 ,guardarropa4);
        svc.agregarRelacion(usuario1 ,guardarropa5);

        List<GuardarropaUsuario> guardarropasU1 = svc.obtenerGuardarropasCompartidosPorElUsuario(usuario1);

        Assert.assertEquals(3, guardarropasU1.size());
        Assert.assertEquals(guardarropa2, guardarropasU1.get(0).guardarropa);
        Assert.assertEquals(guardarropa4, guardarropasU1.get(1).guardarropa);
        Assert.assertEquals(guardarropa5, guardarropasU1.get(2).guardarropa);
    }

}
