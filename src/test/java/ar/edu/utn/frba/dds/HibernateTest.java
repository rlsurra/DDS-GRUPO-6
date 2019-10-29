package ar.edu.utn.frba.dds;


import ar.edu.utn.frba.dds.model.Atuendo;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.categoria.CategoriaAccesorio;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado;
import ar.edu.utn.frba.dds.model.evento.EventoSimple;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.PrendaVacio;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapatilla;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoJean;
import ar.edu.utn.frba.dds.model.prenda.superior.abrigoLigero.TipoSweater;
import ar.edu.utn.frba.dds.model.prenda.superior.remera.TipoRemeraCorta;
import ar.edu.utn.frba.dds.model.usuario.TipoUsuario;
import ar.edu.utn.frba.dds.model.usuario.TipoUsuarioGratuito;
import ar.edu.utn.frba.dds.model.usuario.TipoUsuarioPremium;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Caluroso;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.ReferenciaTemperatura;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class HibernateTest {

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
    private static EntityManager manager;

    @BeforeClass
    public static void beforeclass(){
        manager = JPAUtils.getEntityManager();
    }

    @AfterClass
    public static void afterclass(){
        manager.close();
    }

    @Before
    public void setUp() {

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

   /* @Test
    public void guardarEventoTest() {

            EntityManager manager = JPAUtils.getEntityManager();

            manager.getTransaction().begin();
            manager.persist(prendaAbrigoPesado);
            manager.persist(prendaAbrigoLigero);
            manager.persist(prendaCalzado);
            manager.persist(prendaAccesorio);
            manager.persist(prendaInferior);
            manager.persist(prendaSuperior);
            manager.persist(atuendoElegido);
            manager.persist(evento);
            manager.getTransaction().commit();
            manager.close();
    }*/

    /*@Test
    public void obtenerEventosTest() {
            EntityManager manager = JPAUtils.getEntityManager();
            manager.getTransaction().begin();

            CriteriaBuilder cb = manager.getCriteriaBuilder();
            CriteriaQuery<Evento> query = cb.createQuery(Evento.class);
            Root<Evento> from = query.from(Evento.class);
            query.select(from);
            List<Evento> eventos = manager.createQuery(query).getResultList();
            manager.getTransaction().commit();
            System.out.println(eventos);


    }*/

    @Test
    public void guardarUsuarioTest() {

        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.flush();
        manager.getTransaction().commit();
    }

    @Test
    public void getUsuarioTest() {
        Usuario usuario2;
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
        usuario2 = manager.find(Usuario.class, usuario.getId());
        assertEquals(usuario, usuario2);
    }

    /*@Test
    public void updateUsuarioTest() {
        Usuario usuarioUpdateado;
            EntityManager manager = JPAUtils.getEntityManager();
            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.getTransaction().commit();
            manager.detach(usuario);
            usuario.setTipoUsuario(tipoUsuarioGratuito);
            manager.getTransaction().begin();
            manager.merge(usuario);
            manager.getTransaction().commit();
            manager.detach(usuario);
            usuarioUpdateado = manager.find(usuario.getClass(), usuario.getId());
            assertEquals(usuarioUpdateado.getTipoUsuario(), usuario.getTipoUsuario());
    }*/
}
