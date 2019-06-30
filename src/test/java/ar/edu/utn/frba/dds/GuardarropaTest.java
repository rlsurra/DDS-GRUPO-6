package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.*;
import ar.edu.utn.frba.dds.model.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoAnteojos;
import ar.edu.utn.frba.dds.model.prenda.accesorio.TipoReloj;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapatilla;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapato;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoBermuda;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoJean;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoCamisaCorta;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoCamisaLarga;
import ar.edu.utn.frba.dds.model.prenda.superior.TipoRemeraCorta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
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

