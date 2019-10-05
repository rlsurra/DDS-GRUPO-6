package ar.edu.utn.frba.dds;


import java.awt.Color;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;

import ar.edu.utn.frba.dds.model.Atuendo;
import ar.edu.utn.frba.dds.model.Empleado;
import ar.edu.utn.frba.dds.model.Material;
import ar.edu.utn.frba.dds.model.Prenda;
import ar.edu.utn.frba.dds.model.categoria.CategoriaAccesorio;
import ar.edu.utn.frba.dds.model.categoria.superior.CategoriaSuperiorAbrigoPesado;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.evento.EventoSimple;
import ar.edu.utn.frba.dds.model.prenda.PrendaVacio;
import ar.edu.utn.frba.dds.model.prenda.calzado.TipoZapatilla;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoJean;
import ar.edu.utn.frba.dds.model.prenda.inferior.TipoJogging;
import ar.edu.utn.frba.dds.model.prenda.superior.abrigoLigero.TipoSweater;
import ar.edu.utn.frba.dds.model.prenda.superior.remera.TipoRemeraCorta;


public class HibernateTest {
    private static EntityManager manager;

    private  static EntityManagerFactory emf;



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

//    @Test
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
    		Atuendo atuendoElegido = new Atuendo(prendaSuperior , prendaInferior, prendaCalzado, prendaAccesorio, prendaAbrigoLigero, prendaAbrigoPesado);
    		
    		evento.setAtuendoElegido(atuendoElegido );
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

}
