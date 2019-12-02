package ar.edu.utn.frba.dds.persistence;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

public class Repositorio {

    private static Repositorio instance = null;

    private EntityManager em = JPAUtils.getEntityManagerFactory().createEntityManager();

    private Repositorio(){   }

    public static Repositorio getInstance(){
        if (instance == null){
            instance = new Repositorio();
        }
        return instance;
    }

    public void close(){
        em.close();
    }

    public void save(Entidad entidad) {
        entidad.beforeSave(em);
        em.getTransaction().begin();
        try {
            entidad.beforeSaveTransactional(em);
            Entidad managedEntity = em.merge(entidad);
            entidad.setId(managedEntity.getId());
            entidad.afterSaveTransactional(em);

        } catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.flush();
            em.detach(entidad);
        }
        em.getTransaction().commit();
        entidad.afterSave(em);
    }

    public void delete(Entidad entidad) {
        entidad.beforeDelete(em);
        em.getTransaction().begin();
        try {
            entidad.beforeDeleteTransactional(em);
            em.remove(entidad);
            entidad.afterDeleteTransactional(em);

        } catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        em.getTransaction().commit();
        entidad.afterDelete(em);
    }
    public <T> T getEntidadById(Class<T> clase, Long id){
        return em.find(clase, id);
    }

}
