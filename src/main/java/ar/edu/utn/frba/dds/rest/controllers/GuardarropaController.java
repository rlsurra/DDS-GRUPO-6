package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.GuardarropaUsuarioException;
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
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        usuario.agregarGuardarropa(guardarropa);
        repo.persist(guardarropa);
        return repo.getEntidadById(Guardarropa.class, guardarropa.getId());
    }

    @DeleteMapping(path = "{id}")
    public Guardarropa deleteOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id) throws EntidadNoEncontradaException, UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());

        Guardarropa aBorrar = repo.getEntidadById(Guardarropa.class, id);
        if (aBorrar == null) {
            throw new EntidadNoEncontradaException("No existe el guardarropa indicado");
        }

        Guardarropa g2 = null;
        boolean guardarropaDelUsuario = Boolean.FALSE;
        for (Guardarropa guardarropa : usuario.getGuardarropas()) {
            if ( guardarropa.getId().equals(id) ) {
                g2 = guardarropa;
                guardarropaDelUsuario = Boolean.TRUE;
            }
        }

        if (!guardarropaDelUsuario) {
            throw new GuardarropaUsuarioException("Estas queriendo borrar un guardarropa que no te pertenece");
        }


        repo.delete(aBorrar);
        usuario.getGuardarropas().remove(g2);
        repo.save(usuario);
        return g2;
    }
}
