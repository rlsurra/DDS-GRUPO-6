package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.clima.openWeatherAPI.OpenWeatherAdapter;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OpenweatherTest_Persit {


    ///////////////////
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    /////////////////////


    @Test
    public void testRequestTemperatura_Persist() {
        ////////////entity manager////////////

        emf = Persistence.createEntityManagerFactory("PERSISTENCE");
        manager = emf.createEntityManager();
        ////////////fin entity////////////


        OpenWeatherAdapter temperatura = OpenWeatherAdapter.getTemperaturaByCiudadID(3435910); //Codigo de BsAs
        Assert.assertNotNull(temperatura.toString());
        System.out.println(temperatura.toString());


        manager.getTransaction().begin();
        manager.persist(temperatura);
        manager.getTransaction().commit();
        manager.close();
        emf.close();


    }


}
