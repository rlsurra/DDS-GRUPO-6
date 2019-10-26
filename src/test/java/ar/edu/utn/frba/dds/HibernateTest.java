package ar.edu.utn.frba.dds;


import ar.edu.utn.frba.dds.model.*;
import ar.edu.utn.frba.dds.model.categoria.CategoriaAccesorio;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.evento.EventoSimple;
import ar.edu.utn.frba.dds.model.prenda.PrendaVacio;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapatilla;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoJean;
import ar.edu.utn.frba.dds.model.prenda.superior.abrigoLigero.TipoSweater;
import ar.edu.utn.frba.dds.model.prenda.superior.remera.TipoRemeraCorta;
import ar.edu.utn.frba.dds.model.usuario.TipoUsuario;
import ar.edu.utn.frba.dds.model.usuario.TipoUsuarioPremium;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.Caluroso;
import ar.edu.utn.frba.dds.model.usuario.referenciaTemperatura.ReferenciaTemperatura;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private GrupoUsuario grupoUsuario;
    private ReferenciaTemperatura refTemp;
    private TipoUsuario tipoUsuario;
    private Usuario usuario;

    @Before
    public void setUp(){
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

        grupoUsuario = new GrupoUsuario();
        refTemp = new Caluroso();

        tipoUsuario = new TipoUsuarioPremium();
        usuario = new Usuario();
        usuario.setGuardarropas(new ArrayList<>());
        usuario.setGrupo(grupoUsuario);
        usuario.setRefTemperatura(refTemp);
        usuario.setEventos(new ArrayList<>());
        usuario.getEventos().add(evento);
        usuario.setTipoUsuario(tipoUsuario);

    }

    @Test
    public void guardarEventoTest() {

        try {
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
        } catch (Exception e) {
            System.out.println("Error en persistencia de evento: " + e);
            e.printStackTrace();
        } finally {
            JPAUtils.close();
        }

    }

    @Test
    public void obtenerEventosTest() {
        try {
            EntityManager manager = JPAUtils.getEntityManager();
            manager.getTransaction().begin();

            CriteriaBuilder cb = manager.getCriteriaBuilder();
            CriteriaQuery<Evento> query = cb.createQuery(Evento.class);
            Root<Evento> from = query.from(Evento.class);
            query.select(from);
            List<Evento> eventos = manager.createQuery(query).getResultList();
            manager.getTransaction().commit();
            System.out.println(eventos);

        } catch (Exception e) {
            System.out.println("Error en persistencia de evento: " + e);
            e.printStackTrace();
        } finally {
            JPAUtils.close();
        }
    }

    @Test
    public void guardarUsuarioTest() {

        try {
            EntityManager manager = JPAUtils.getEntityManager();
            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en persistencia de usuario: " + e);
            e.printStackTrace();
        } finally {
            JPAUtils.close();
        }
    }

    @Test
    public void getUsuarioTest(){
        Usuario usuario2 = null;
        try {
            EntityManager manager = JPAUtils.getEntityManager();
            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.getTransaction().commit();
            usuario2 = manager.find(Usuario.class, usuario.getId());
        } catch (Exception e) {
            System.out.println("Error en la recuperacion de un usuario: " + e);
            e.printStackTrace();
        } finally {
            JPAUtils.close();
        }

        assertEquals(usuario, usuario2);

    }
}
