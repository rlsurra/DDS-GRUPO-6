package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.GrupoUsuario;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ObtenerGuardarropasGrupoTest {

    List<Usuario> usuarios;

    @Before
    public void setUp() {
        GeneradorGuardarropa generadorGuardarropa = new GeneradorGuardarropa();
        usuarios = generadorGuardarropa.getCasosDePrueba();
    }

    @Test
    public void obtenerGuardarropasGrupoTest() {
        GrupoUsuario grupo1 = new GrupoUsuario("grupo1");
        grupo1.setUsuarios(usuarios);
        System.out.println(grupo1.getGuardarropaGrupo());
    }


}

