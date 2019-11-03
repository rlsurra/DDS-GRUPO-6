package ar.edu.utn.frba.dds;


import ar.edu.utn.frba.dds.model.atuendo.Atuendo;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
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
import org.junit.Before;
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

    private Prenda prendaSuperior;
    private Prenda prendaInferior;
    private  Prenda prendaCalzado;
    private Prenda prendaAccesorio;
    private Prenda prendaAbrigoLigero;
    private Prenda prendaAbrigoPesado;
    private Atuendo atuendoElegido;
    private EventoSimple evento;
    private TipoUsuario tipoUsuarioGratuito;
    private Usuario usuario;
    private Repositorio repositorio;
    private EntityManagerFactory emFactory;
    private Guardarropa guardarropa;

    @Before
    public void setUp() {
        emFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
        repositorio = new Repositorio(emFactory.createEntityManager());

        evento = new EventoSimple(3435910, LocalDateTime.now());
        prendaSuperior = new Prenda(new TipoRemeraCorta(), Material.ALGODON, Color.ORANGE);
        prendaSuperior.setId(null);
        prendaInferior = new Prenda(new TipoJean(), Material.JEAN, Color.BLACK);
        prendaInferior.setId(null);
        prendaCalzado = new Prenda(new TipoZapatilla(), Material.LONA, Color.DARK_GRAY);
        prendaCalzado.setId(null);
        prendaAccesorio = new PrendaVacio(CategoriaAccesorio.CATEGORIA_ACCESORIO);
        prendaAccesorio.setId(null);
        prendaAbrigoLigero = new Prenda(new TipoSweater(), Material.LANA, Color.YELLOW);
        prendaAbrigoLigero.setId(null);
        prendaAbrigoPesado = new PrendaVacio(CategoriaSuperiorAbrigoPesado.CATEGORIA_SUPERIOR_ABRIGO_PESADO);
        prendaAbrigoPesado.setId(null);
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
        usuario.setId(null);

        guardarropa = new Guardarropa();
        guardarropa.setPrendas(new ArrayList<>());
        guardarropa.getPrendas().add(prendaSuperior);
        guardarropa.getPrendas().add(prendaInferior);
        guardarropa.getPrendas().add(prendaCalzado);
        guardarropa.getPrendas().add(prendaAccesorio);
        guardarropa.getPrendas().add(prendaSuperior);
        guardarropa.getPrendas().add(prendaAbrigoLigero);
        guardarropa.getPrendas().add(prendaAbrigoPesado);

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

    @Test
    public void guardarEventoTest() {
        repositorio.save(evento);
    }

    @Test
    public void getEventoTest() {
        repositorio.save(evento);
        Evento evento2 = repositorio.getEntidadById(Evento.class, evento.getId());
        assertEquals(evento.getNombre(), evento2.getNombre());
        assertEquals(evento.getCiudad(), evento2.getCiudad());
    }

    @Test
    public void deleteEventoTest() {
        repositorio.save(evento);
        Evento evento2 = repositorio.getEntidadById(Evento.class, evento.getId());
        repositorio.delete(evento2);
        evento2 = repositorio.getEntidadById(Evento.class, evento.getId());
        assertNull(evento2);
    }

    @Test
    public void updateEventoTest() {
        String nombreNuevo = "Un Nombre Nuevo";
        repositorio.save(evento);
        Evento evento2 = repositorio.getEntidadById(Evento.class, evento.getId());
        evento2.setNombre(nombreNuevo);
        repositorio.save(evento2);
        evento2 = repositorio.getEntidadById(Evento.class, evento2.getId());
        assertEquals(nombreNuevo, evento2.getNombre());
    }

    @Test
    public void guardarGuardarropaTest() {
        repositorio.save(guardarropa);
    }

    @Test
    public void getGuardarropaTest() {
        repositorio.save(guardarropa);
        Guardarropa guardarropa2 = repositorio.getEntidadById(Guardarropa.class, guardarropa.getId());
        assertEquals(guardarropa.getNombre(), guardarropa2.getNombre());
    }

    @Test
    public void deleteGuardarropaTest() {
        repositorio.save(guardarropa);
        Guardarropa guardarropa2 = repositorio.getEntidadById(Guardarropa.class, guardarropa.getId());
        repositorio.delete(guardarropa2);
        guardarropa2 = repositorio.getEntidadById(Guardarropa.class, guardarropa.getId());
        assertNull(guardarropa2);
    }

    @Test
    public void updateGuardarropaTest() {
        String nombreNuevo = "Un Nombre Nuevo";
        repositorio.save(guardarropa);
        Guardarropa guardarropa2 = repositorio.getEntidadById(Guardarropa.class, guardarropa.getId());
        guardarropa2.setNombre(nombreNuevo);
        repositorio.save(guardarropa2);
        guardarropa2 = repositorio.getEntidadById(Guardarropa.class, guardarropa2.getId());
        assertEquals(nombreNuevo, guardarropa2.getNombre());
    }

    @Test
    public void guardarPrendasTest() {
        repositorio.save(prendaAbrigoLigero);
    }

    @Test
    public void getPrendasTest() {
        repositorio.save(prendaAbrigoLigero);
        Prenda guardarropa2 = repositorio.getEntidadById(Prenda.class, prendaAbrigoLigero.getId());
        assertEquals(prendaAbrigoLigero.getNombre(), guardarropa2.getNombre());
    }

    @Test
    public void deletePrendasTest() {
        repositorio.save(prendaAbrigoLigero);
        Prenda prendaAbrigoLigero2 = repositorio.getEntidadById(Prenda.class, prendaAbrigoLigero.getId());
        repositorio.delete(prendaAbrigoLigero2);
        prendaAbrigoLigero2 = repositorio.getEntidadById(Prenda.class, prendaAbrigoLigero2.getId());
        assertNull(prendaAbrigoLigero2);
    }

    @Test
    public void updatePrendaTest() {
        String nombreNuevo = "Un Nombre Nuevo";
        repositorio.save(prendaAbrigoLigero);
        Prenda prendaAbrigoLigero2 = repositorio.getEntidadById(Prenda.class, prendaAbrigoLigero.getId());
        prendaAbrigoLigero2.setNombre(nombreNuevo);
        repositorio.save(prendaAbrigoLigero2);
        prendaAbrigoLigero2 = repositorio.getEntidadById(Prenda.class, prendaAbrigoLigero2.getId());
        assertEquals(nombreNuevo, prendaAbrigoLigero2.getNombre());
    }

}
