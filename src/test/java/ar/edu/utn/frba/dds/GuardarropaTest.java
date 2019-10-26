package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.Atuendo;
import ar.edu.utn.frba.dds.model.Guardarropa;
import ar.edu.utn.frba.dds.model.evento.EventoSimple;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class GuardarropaTest {

    private List<Usuario> usuarios;

    @Before
    public void setUp() {
        GeneradorGuardarropa generadorGuardarropa = new GeneradorGuardarropa();
        usuarios = generadorGuardarropa.getCasosDePrueba();
    }

    @Test
    public void generarAtuendoTest() {
        Usuario usuario = usuarios.get(new Random().nextInt(usuarios.size()));
        List<Guardarropa> guardarropas = usuario.getGrupo().getGuardarropaGrupo();
        System.out.println("Guardarropas: " + guardarropas.size());

        Guardarropa guardarropa = guardarropas.get(new Random().nextInt(guardarropas.size()));
        List<Atuendo> atuendos = guardarropa.generarSugerencias(usuario, new EventoSimple(2643743, LocalDateTime.now()));
        System.out.println("Atuendos posibles: " + atuendos.size());
        System.out.println("Niveles de calor de atuendos posibles: " + atuendos.stream().map(Atuendo::getNivelDeCalor).collect(Collectors.toList()));


        if (atuendos.isEmpty()) {
            System.out.println("No hay atuendos posibles con los guardarropas del usuario");
        } else {
            System.out.println("Atuendo elegido: " + atuendos.get(new Random().nextInt(atuendos.size())));
        }
    }

}

