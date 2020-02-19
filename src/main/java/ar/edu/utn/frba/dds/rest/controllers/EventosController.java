package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.evento.EventoFactory;
import ar.edu.utn.frba.dds.model.evento.EventoPeriodico;
import ar.edu.utn.frba.dds.model.evento.EventoSimple;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import ar.edu.utn.frba.dds.rest.DTOs.EventoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path = "eventos")
public class EventosController {

    @GetMapping(produces = "application/json")
    public List<Evento> findAll(@RequestHeader("Authorization") String token) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        List<Evento> respuesta = null;
        Usuario usuario = null;
        Session session = Autenticacion.getSession(token);
        usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        respuesta = usuario.getEventos();
        return respuesta;
    }

    @GetMapping(path = "{id}")
    public Evento findOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id) throws UserNotLoggedException, EntidadNoEncontradaException {
        Repositorio repo = Repositorio.getInstance();
        Evento respuesta = null;
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        respuesta = usuario.getEventos().stream().filter(evento -> evento.getId().equals(id)).findFirst().orElse(null);
        if (respuesta == null) {
            throw new EntidadNoEncontradaException();
        }
        return respuesta;
    }

    @PutMapping
    public Evento RefreshOne(@RequestHeader("Authorization") String token, @RequestBody Evento evento) throws UserNotLoggedException, EntidadNoEncontradaException {
        Repositorio repo = Repositorio.getInstance();
        Evento respuesta = null;
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        Evento old = usuario.getEventos().stream().filter(eventoU -> eventoU.getId().equals(evento.getId())).findFirst().orElse(null);
        if (old == null) {
            throw new EntidadNoEncontradaException();
        }
        repo.save(evento);
        respuesta = repo.getEntidadById(Evento.class, evento.getId());
        return respuesta;
    }

    @PostMapping
    public Evento AddOne(@RequestHeader("Authorization") String token, @RequestBody EventoDTO eventoDTO) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        Evento evento = null;

        if (eventoDTO.getCiudad() == null){
            throw new ParametrosInvalidosException("El evento debe realizarse en alguna ciudad");
        }

        evento = EventoFactory.getEvento(eventoDTO.getTipo());

        evento = evento.fillWithDTO(eventoDTO, evento);

        usuario.agregarEvento(evento);
        return evento;
    }

    @DeleteMapping(path = "{id}")
    public Evento deleteOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id) throws EntidadNoEncontradaException, UserNotLoggedException {
        Repositorio repo = null;
        Evento respuesta = null;
        repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        Evento evento = usuario.getEventos().stream().filter(eventoU -> eventoU.getId().equals(id)).findFirst().orElse(null);
        if (evento == null) {
            throw new EntidadNoEncontradaException();
        }
        repo.delete(evento);
        usuario.getEventos().remove(evento);
        repo.save(usuario);
        respuesta = evento;
        return respuesta;
    }
}
