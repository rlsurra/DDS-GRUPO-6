package ar.edu.utn.frba.dds.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");

    public static EntityManagerFactory getEntityManagerFactory() {
        return EntityManagerFactory;
    }

}
