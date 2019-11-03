package ar.edu.utn.frba.dds.persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public abstract class Entidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected String nombre;

    protected Entidad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void beforeSave(EntityManager em) {
    }

    public void beforeSaveTransactional(EntityManager em) {
    }

    public void afterSaveTransactional(EntityManager em) {
    }

    public void afterSave(EntityManager em) {
    }

    public void beforeDelete(EntityManager em) {
    }

    public void beforeDeleteTransactional(EntityManager em) {
    }

    public void afterDeleteTransactional(EntityManager em) {
    }

    public void afterDelete(EntityManager em) {
    }
}
