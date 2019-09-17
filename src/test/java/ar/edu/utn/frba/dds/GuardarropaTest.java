package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.*;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class GuardarropaTest {
    List<Usuario> usuarios;
    @Before
    public void setUp() {
        GeneradorGuardarropa generadorGuardarropa = new GeneradorGuardarropa();
        usuarios = generadorGuardarropa.getCasosDePrueba();
    }

    @Test
    public void generarAtuendoTest(){
        Atuendo sugerenciaAleatoria = usuarios.get(0).getGuardarropas().get(0).getSugerenciaAleatoria();
        System.out.println(sugerenciaAleatoria);
    }


}

