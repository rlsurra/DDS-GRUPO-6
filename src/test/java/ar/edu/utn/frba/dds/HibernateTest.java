package ar.edu.utn.frba.dds;


import ar.edu.utn.frba.dds.model.Empleado;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


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



}
