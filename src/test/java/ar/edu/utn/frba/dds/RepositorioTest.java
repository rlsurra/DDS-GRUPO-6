package ar.edu.utn.frba.dds;


import ar.edu.utn.frba.dds.model.atuendo.Atuendo;
import ar.edu.utn.frba.dds.model.categoria.*;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoLigero;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.evento.EventoSimple;
import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorAplicacion;
import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorCorreo;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.PrendaVacio;
import ar.edu.utn.frba.dds.model.prenda.PuntajePrenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaCalzado;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaInferior;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrendaSuperior;
import ar.edu.utn.frba.dds.model.usuario.HistorialAtuendos.RegistroAtuendoSeleccionado;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Caluroso;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.ReferenciaTemperatura;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuario;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioGratuito;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioPremium;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class RepositorioTest {

    private Prenda prendaSuperior;
    private Prenda prendaInferior;
    private Prenda prendaCalzado;
    private Prenda prendaAccesorio;
    private Prenda prendaAbrigoLigero;
    private Prenda prendaAbrigoPesado;
    private Atuendo atuendoElegido;
    private EventoSimple evento;
    private TipoUsuario tipoUsuarioGratuito;
    private Usuario usuario;
    private Repositorio repositorio;
    private Guardarropa guardarropa;
    private RegistroAtuendoSeleccionado historialAtuendo;
    private PuntajePrenda preferencia;
    private NotificadorCorreo notificadorCorreo;
    private NotificadorAplicacion notificadorAplicacion;
    private TipoPrenda TipoRemeraCorta;
    private Material ALGODON;
    private TipoPrenda TipoJean;
    private Material JEAN;
    private TipoPrenda TipoZapatilla;
    private Material LONA;
    private TipoPrenda TipoSweater;
    private Material LANA;

    @Before
    public void setUp() {
        ALGODON = new Material("ALGODON");
        TipoRemeraCorta = new TipoPrendaSuperior(CategoriaSuperior.getInstance());
        TipoRemeraCorta.getMaterialesPermitidos().add(ALGODON);

        JEAN = new Material("JEAN");
        TipoJean = new TipoPrendaInferior(CategoriaInferior.getInstance());
        TipoJean.getMaterialesPermitidos().add(JEAN);

        LONA = new Material("LONA");
        TipoZapatilla = new TipoPrendaCalzado(CategoriaCalzado.getInstance());
        TipoZapatilla.getMaterialesPermitidos().add(LONA);

        LANA = new Material("LANA");
        TipoSweater = new TipoPrendaSuperior(CategoriaSuperiorAbrigoLigero.getInstance());
        TipoSweater.getMaterialesPermitidos().add(LANA);

        repositorio = Repositorio.getInstance();
        evento = new EventoSimple(3435910, LocalDateTime.now());

        prendaSuperior = new Prenda("", TipoRemeraCorta, ALGODON, "255|200|0|1");
        prendaSuperior.setId(null);
        prendaInferior = new Prenda("", TipoJean, JEAN, "0|0|0|1");
        prendaInferior.setId(null);
        prendaCalzado = new Prenda("", TipoZapatilla, LONA, "64|64|64|1");
        prendaCalzado.setId(null);
        prendaAccesorio = new PrendaVacio(CategoriaAccesorio.getInstance());
        prendaAccesorio.setId(null);
        prendaAbrigoLigero = new Prenda("", TipoSweater, LANA, "255|255|0|1");
        prendaAbrigoLigero.setId(null);
        prendaAbrigoPesado = new PrendaVacio(CategoriaSuperiorAbrigoPesado.getInstance());
        prendaAbrigoPesado.setId(null);
        atuendoElegido = new Atuendo(prendaSuperior, prendaInferior, prendaCalzado, prendaAccesorio, prendaAbrigoLigero, prendaAbrigoPesado);
        evento.setAtuendoElegido(atuendoElegido);
        evento.setTemperatura(22d);
        notificadorAplicacion = new NotificadorAplicacion();
        notificadorCorreo = new NotificadorCorreo(notificadorAplicacion);
        evento.setNotificadorEvento(notificadorCorreo);

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

        historialAtuendo = new RegistroAtuendoSeleccionado();
        historialAtuendo.setAtuendo(atuendoElegido);
        historialAtuendo.setUsuario(usuario);
        historialAtuendo.setEvento(evento);
        historialAtuendo.setFecha(LocalTime.now());
        historialAtuendo.setNombre("Hola");

        preferencia = new PuntajePrenda(usuario,prendaAccesorio,5.00);

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
    public void guardarRegistroAtuendoSeleccionadoTest() {
        repositorio.save(historialAtuendo);
    }

    @Test
    public void getRegistroAtuendoSeleccionadoTest() {
        repositorio.save(historialAtuendo);
        RegistroAtuendoSeleccionado historialAtuendo2 = repositorio.getEntidadById(RegistroAtuendoSeleccionado.class, historialAtuendo.getId());
        assertEquals(historialAtuendo.getNombre(), historialAtuendo2.getNombre());
    }

    @Test
    public void deleteRegistroAtuendoSeleccionadoTest() {
        repositorio.save(historialAtuendo);
        RegistroAtuendoSeleccionado historialAtuendo2 = repositorio.getEntidadById(RegistroAtuendoSeleccionado.class, historialAtuendo.getId());
        repositorio.delete(historialAtuendo2);
        historialAtuendo2 = repositorio.getEntidadById(RegistroAtuendoSeleccionado.class, historialAtuendo2.getId());
        assertNull(historialAtuendo2);
    }

    @Test
    public void updateRegistroAtuendoSeleccionadoTest() {
        String nombreNuevo = "Un Nombre Nuevo";
        repositorio.save(historialAtuendo);
        RegistroAtuendoSeleccionado historialAtuendo2 = repositorio.getEntidadById(RegistroAtuendoSeleccionado.class, historialAtuendo.getId());
        historialAtuendo2.setNombre(nombreNuevo);
        repositorio.save(historialAtuendo2);
        historialAtuendo2 = repositorio.getEntidadById(RegistroAtuendoSeleccionado.class, historialAtuendo2.getId());
        assertEquals(nombreNuevo, historialAtuendo2.getNombre());
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

    @Test
    public void guardarPreferenciaTest() {
        repositorio.save(preferencia);
    }

    @Test
    public void getPreferenciaTest() {
        repositorio.save(preferencia);
        PuntajePrenda preferencia2 = repositorio.getEntidadById(PuntajePrenda.class, preferencia.getId());
        assertEquals(preferencia.getNombre(), preferencia2.getNombre());
    }

    @Test
    public void deletePreferenciaTest() {
        repositorio.save(preferencia);
        PuntajePrenda preferencia2 = repositorio.getEntidadById(PuntajePrenda.class, preferencia.getId());
        repositorio.delete(preferencia2);
        preferencia2 = repositorio.getEntidadById(PuntajePrenda.class, preferencia2.getId());
        assertNull(preferencia2);
    }

    @Test
    public void updatePreferenciaTest() {
        Double puntajeNuevo = 2.00;
        repositorio.save(preferencia);
        PuntajePrenda preferencia2 = repositorio.getEntidadById(PuntajePrenda.class, preferencia.getId());
        preferencia2.setPuntaje(puntajeNuevo);
        repositorio.save(preferencia2);
        preferencia2 = repositorio.getEntidadById(PuntajePrenda.class, preferencia2.getId());
        assertEquals(puntajeNuevo, preferencia2.getPuntaje());
    }

}
