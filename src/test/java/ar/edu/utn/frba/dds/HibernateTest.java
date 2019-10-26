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
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class HibernateTest {
    private static EntityManager manager;

    private static EntityManagerFactory emf;


    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("PERSISTENCE");
        manager = emf.createEntityManager();


        Empleado emp = new Empleado();
        emp.setNombre("pepe");
        emp.setApellido("dsfse");
        emp.setFechanac(25);

        manager.getTransaction().begin();
        manager.persist(emp);
        manager.getTransaction().commit();
        manager.close();
        emf.close();
    }

    @Test
    public void guardarEventoTest() {

        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            manager = emf.createEntityManager();

            EventoSimple evento = new EventoSimple(3435910, LocalDateTime.now());

            Prenda prendaSuperior = new Prenda(new TipoRemeraCorta(), Material.ALGODON, Color.ORANGE);
            Prenda prendaInferior = new Prenda(new TipoJean(), Material.JEAN, Color.BLACK);
            Prenda prendaCalzado = new Prenda(new TipoZapatilla(), Material.LONA, Color.DARK_GRAY);
            Prenda prendaAccesorio = new PrendaVacio(CategoriaAccesorio.CATEGORIA_ACCESORIO);
            Prenda prendaAbrigoLigero = new Prenda(new TipoSweater(), Material.LANA, Color.YELLOW);
            Prenda prendaAbrigoPesado = new PrendaVacio(CategoriaSuperiorAbrigoPesado.CATEGORIA_SUPERIOR_ABRIGO_PESADO);
            Atuendo atuendoElegido = new Atuendo(prendaSuperior, prendaInferior, prendaCalzado, prendaAccesorio, prendaAbrigoLigero, prendaAbrigoPesado);

            evento.setAtuendoElegido(atuendoElegido);
            evento.setTemperatura(22d);

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
            emf.close();
        }

    }

    @Test
    public void obtenerEventosTest() {
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            manager = emf.createEntityManager();

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
            emf.close();
        }
    }

    @Test
    public void guardarUsuarioTest() {

        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            manager = emf.createEntityManager();

            GrupoUsuario grupoUsuario = new GrupoUsuario();
            ReferenciaTemperatura refTemp = new Caluroso();
            Evento evento = new Evento(2);

            TipoUsuario tipoUsuario = new TipoUsuarioPremium();
            Usuario usuario = new Usuario();
            usuario.setGuardarropas(new ArrayList<Guardarropa>());
            usuario.setGrupo(grupoUsuario);
            usuario.setRefTemperatura(refTemp);
            usuario.setEventos(new ArrayList<Evento>());
            usuario.getEventos().add(evento);
            usuario.setTipoUsuario(tipoUsuario);

            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en persistencia de usuario: " + e);
            e.printStackTrace();
        } finally {
            emf.close();
        }
    }
}
