package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.Autenticacion.Sessions;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.JPAUtils;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import ar.edu.utn.frba.dds.rest.service.RepositorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping(path = "guardarropas")
public class GuardarropaController {

    @GetMapping
    public List<Guardarropa> findAll(@RequestHeader("Authorization") String token) {
        Repositorio repo = null;
        List<Guardarropa> respuesta = null;
        Usuario usuario = null;
        try {
            repo = new Repositorio(JPAUtils.getEntityManagerFactory().createEntityManager());
            Session session = Sessions.getSessiones().get(token);
            usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
            respuesta = usuario.getGuardarropas();
        } finally {
            if (repo != null){
                repo.close();
            }
        }
        return respuesta;
    }

    @GetMapping(path = "{id}")
    public Guardarropa findOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id) {
        Repositorio repo = null;
        Guardarropa respuesta = null;
        try {
            repo = new Repositorio(JPAUtils.getEntityManagerFactory().createEntityManager());
            Session session = Sessions.getSessiones().get(token);
            Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
            respuesta = usuario.getGuardarropas().stream().filter(guardarropa -> guardarropa.getId().equals(id)).findFirst().orElse(null);
        } finally {
            if (repo != null){
                repo.close();
            }
        }
        return respuesta;
    }

    @PutMapping
    public Guardarropa RefreshOne(@RequestHeader("Authorization") String token, @RequestBody Guardarropa guardarropa) {
        Repositorio repo = null;
        Guardarropa respuesta = null;
        try {
            repo = new Repositorio(JPAUtils.getEntityManagerFactory().createEntityManager());
            Session session = Sessions.getSessiones().get(token);
            Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
            Guardarropa old = usuario.getGuardarropas().stream().filter(guardarropaU -> guardarropaU.getId().equals(guardarropa.getId())).findFirst().orElse(null);
            repo.save(guardarropa);
            respuesta = repo.getEntidadById(Guardarropa.class, guardarropa.getId());
        } finally {
            if (repo != null){
                repo.close();
            }
        }
        return respuesta;
    }

    @PostMapping
    public Guardarropa AddOne(@RequestHeader("Authorization") String token, @RequestBody Guardarropa guardarropa) {
        Repositorio repo = null;
        Guardarropa respuesta = null;
        try {
            repo = new Repositorio(JPAUtils.getEntityManagerFactory().createEntityManager());
            Session session = Sessions.getSessiones().get(token);
            Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
            repo.save(guardarropa);
            respuesta = repo.getEntidadById(Guardarropa.class, guardarropa.getId());
        } finally {
            if (repo != null){
                repo.close();
            }
        }
        return respuesta;
    }

    @DeleteMapping(path = "{id}")
    public Guardarropa deleteOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id) throws EntidadNoEncontradaException {
        Repositorio repo = null;
        Guardarropa respuesta = null;
        try {
            repo = new Repositorio(JPAUtils.getEntityManagerFactory().createEntityManager());
            Session session = Sessions.getSessiones().get(token);
            Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
            Guardarropa guardarropa2 = usuario.getGuardarropas().stream().filter(guardarropa -> guardarropa.getId().equals(id)).findFirst().orElse(null);
            if (guardarropa2 == null){
                throw new EntidadNoEncontradaException();
            }
            repo.delete(guardarropa2);
            respuesta = guardarropa2;
        } finally {
            if (repo != null){
                repo.close();
            }
        }
        return respuesta;
    }
}
