package ar.edu.utn.frba.dds;


import ar.edu.utn.frba.dds.model.atuendo.Atuendo;
import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.categoria.CategoriaAccesorio;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado;
import ar.edu.utn.frba.dds.model.evento.EventoSimple;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.PrendaVacio;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.calzado.TipoZapatilla;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.inferior.TipoJean;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.abrigoLigero.TipoSweater;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.superior.remera.TipoRemeraCorta;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuario;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioGratuito;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioPremium;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Caluroso;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.ReferenciaTemperatura;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class RepositorioTest {

    private static Prenda prendaSuperior;
    private static Prenda prendaInferior;
    private static Prenda prendaCalzado;
    private static Prenda prendaAccesorio;
    private static Prenda prendaAbrigoLigero;
    private static Prenda prendaAbrigoPesado;
    private static Atuendo atuendoElegido;
    private static EventoSimple evento;
    private static TipoUsuario tipoUsuarioGratuito;
    private static Usuario usuario;
    private static Repositorio repositorio;
    private static EntityManagerFactory emFactory;

    @BeforeClass
    public static void setUp() {
        emFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
        repositorio = new Repositorio(emFactory.createEntityManager());

        evento = new EventoSimple(3435910, LocalDateTime.now());
        prendaSuperior = new Prenda(new TipoRemeraCorta(), Material.ALGODON, Color.ORANGE);
        prendaInferior = new Prenda(new TipoJean(), Material.JEAN, Color.BLACK);
        prendaCalzado = new Prenda(new TipoZapatilla(), Material.LONA, Color.DARK_GRAY);
        prendaAccesorio = new PrendaVacio(CategoriaAccesorio.CATEGORIA_ACCESORIO);
        prendaAbrigoLigero = new Prenda(new TipoSweater(), Material.LANA, Color.YELLOW);
        prendaAbrigoPesado = new PrendaVacio(CategoriaSuperiorAbrigoPesado.CATEGORIA_SUPERIOR_ABRIGO_PESADO);
        atuendoElegido = new Atuendo(prendaSuperior, prendaInferior, prendaCalzado, prendaAccesorio, prendaAbrigoLigero, prendaAbrigoPesado);
        evento.setAtuendoElegido(atuendoElegido);
        evento.setTemperatura(22d);

        ReferenciaTemperatura refTemp = new Caluroso();

        TipoUsuario tipoUsuarioPremium = new TipoUsuarioPremium();
        tipoUsuarioGratuito = new TipoUsuarioGratuito();
        usuario = new Usuario();
        usuario.setGuardarropas(new ArrayList<>());
        usuario.setRefTemperatura(refTemp);
        usuario.setEventos(new ArrayList<>());
        usuario.getEventos().add(evento);
        usuario.setTipoUsuario(tipoUsuarioPremium);

    }

    @Test
    public void guardarUsuarioTest() {
        repositorio.save(usuario);
    }

    @Test
    public void getUsuarioTest() {
        repositorio.save(usuario);
        Usuario usuario2 = repositorio.getEntidadById(Usuario.class, usuario.getId());
        assertEquals(usuario.getNombre(), usuario2.getNombre());
        assertEquals(usuario.getRefTemperatura().getClass(), usuario2.getRefTemperatura().getClass());
        assertEquals(usuario.getEventos().size(), usuario2.getEventos().size());
    }

    @Test
    public void deleteUsuarioTest() {
        repositorio.save(usuario);
        Usuario usuario2 = repositorio.getEntidadById(Usuario.class, usuario.getId());
        repositorio.delete(usuario2);
        usuario2 = repositorio.getEntidadById(Usuario.class, usuario.getId());
        assertNull(usuario2);
    }

    @Test
    public void updateUsuarioTest() {
        String nombreNuevo = "Un Nombre Nuevo";
        repositorio.save(usuario);
        Usuario usuario2 = repositorio.getEntidadById(Usuario.class, usuario.getId());
        usuario2.setNombre(nombreNuevo);
        repositorio.save(usuario2);
        usuario2 = repositorio.getEntidadById(Usuario.class, usuario2.getId());
        assertEquals(nombreNuevo, usuario2.getNombre());
    }

}
