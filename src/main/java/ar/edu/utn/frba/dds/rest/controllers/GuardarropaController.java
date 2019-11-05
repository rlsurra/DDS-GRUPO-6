package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.Autenticacion.Sessions;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.rest.service.RepositorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "guardarropas")
public class GuardarropaController {

    @Autowired
    private RepositorioService repo;

    @GetMapping
    public List<Guardarropa> findAll(@RequestHeader("Authorization") String token) {
        Session session = Sessions.getSessiones().get(token);
        return session.getUsuario().getGuardarropas();
    }

    @GetMapping(path = "{id}")
    public Guardarropa findOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id) {
        Session session = Sessions.getSessiones().get(token);
        return session.getUsuario().getGuardarropas().stream().filter(guardarropa -> guardarropa.getId().equals(id)).findFirst().orElse(null);
    }

    @PutMapping
    public Guardarropa RefreshOne(@RequestHeader("Authorization") String token, @RequestBody Guardarropa guardarropa) {
        Session session = Sessions.getSessiones().get(token);
        Guardarropa old = session.getUsuario().getGuardarropas().stream().filter(guardarropaU -> guardarropaU.getId().equals(guardarropa.getId())).findFirst().orElse(null);
        repo.getRepositorio().save(guardarropa);
        session.setUsuario(repo.getRepositorio().getEntidadById(Usuario.class, session.getUsuario().getId()));
        return repo.getRepositorio().getEntidadById(Guardarropa.class, guardarropa.getId());
    }

    @PostMapping
    public Guardarropa AddOne(@RequestHeader("Authorization") String token, @RequestBody Guardarropa guardarropa) {
        Session session = Sessions.getSessiones().get(token);
        session.getUsuario().getGuardarropas().add(guardarropa);
        repo.getRepositorio().save(guardarropa);
        return repo.getRepositorio().getEntidadById(Guardarropa.class, guardarropa.getId());
    }

    @DeleteMapping(path = "{id}")
    public Guardarropa deleteOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id) {
        Session session = Sessions.getSessiones().get(token);
        Guardarropa guardarropa2 = session.getUsuario().getGuardarropas().stream().filter(guardarropa -> guardarropa.getId().equals(id)).findFirst().orElse(null);
        assert guardarropa2 != null;
        repo.getRepositorio().delete(guardarropa2);
        return guardarropa2;
    }
}
