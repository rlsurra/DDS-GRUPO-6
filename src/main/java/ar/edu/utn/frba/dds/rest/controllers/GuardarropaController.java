package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path = "guardarropas")
public class GuardarropaController {

    @GetMapping
    public List<Guardarropa> findAll(@RequestHeader("Authorization") String token) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        List<Guardarropa> respuesta = null;
        Usuario usuario = null;
        Session session = Autenticacion.getSession(token);
        usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        respuesta = usuario.getGuardarropas();
        respuesta.forEach(guardarropa -> Hibernate.initialize(guardarropa.getPrendas()));
        return respuesta;
    }

    @GetMapping(path = "{id}")
    public Guardarropa findOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id) throws UserNotLoggedException, EntidadNoEncontradaException {
        Repositorio repo = Repositorio.getInstance();
        Guardarropa respuesta = null;
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        respuesta = usuario.getGuardarropas().stream().filter(guardarropa -> guardarropa.getId().equals(id)).findFirst().orElse(null);
        if (respuesta == null) {
            throw new EntidadNoEncontradaException();
        }
        return respuesta;
    }

    @PutMapping
    public Guardarropa RefreshOne(@RequestHeader("Authorization") String token, @RequestBody Guardarropa guardarropa) throws UserNotLoggedException, EntidadNoEncontradaException {
        Repositorio repo = Repositorio.getInstance();
        Guardarropa respuesta = null;
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        Guardarropa old = usuario.getGuardarropas().stream().filter(guardarropaU -> guardarropaU.getId().equals(guardarropa.getId())).findFirst().orElse(null);
        if (old == null) {
            throw new EntidadNoEncontradaException();
        }
        repo.save(guardarropa);
        respuesta = repo.getEntidadById(Guardarropa.class, guardarropa.getId());
        return respuesta;
    }

    @PostMapping
    public Guardarropa AddOne(@RequestHeader("Authorization") String token, @RequestBody Guardarropa guardarropa) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        Guardarropa respuesta = null;
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        repo.persist(guardarropa);
        usuario.agregarGuardarropa(guardarropa);
        respuesta = repo.getEntidadById(Guardarropa.class, guardarropa.getId());
        return respuesta;
    }

    @DeleteMapping(path = "{id}")
    public Guardarropa deleteOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id) throws EntidadNoEncontradaException, UserNotLoggedException {
        Repositorio repo = null;
        Guardarropa respuesta = null;
        repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        Guardarropa guardarropa2 = usuario.getGuardarropas().stream().filter(guardarropa -> guardarropa.getId().equals(id)).findFirst().orElse(null);
        if (guardarropa2 == null) {
            throw new EntidadNoEncontradaException();
        }
        repo.delete(guardarropa2);
        usuario.getGuardarropas().remove(guardarropa2);
        repo.save(usuario);
        respuesta = guardarropa2;
        return respuesta;
    }
}
