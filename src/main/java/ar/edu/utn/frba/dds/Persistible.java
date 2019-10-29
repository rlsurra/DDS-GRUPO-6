package ar.edu.utn.frba.dds;

import javax.persistence.EntityManager;

public abstract class Persistible {

    public void save(){
        EntityManager manager = JPAUtils.getEntityManager();

        manager.getTransaction().begin();
        manager.persist(this);
        manager.getTransaction().commit();
        manager.close();
    }

    public void delete(){
        EntityManager manager = JPAUtils.getEntityManager();

        manager.getTransaction().begin();
        manager.remove(this);
        manager.getTransaction().commit();
        manager.close();
    }

    public void update(){
        EntityManager manager = JPAUtils.getEntityManager();

        manager.getTransaction().begin();
        manager.merge(this);
        manager.getTransaction().commit();
        manager.detach(this);
        manager.close();

    }

}
