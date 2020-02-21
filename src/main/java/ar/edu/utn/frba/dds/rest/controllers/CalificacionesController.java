package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.NoSePuedePuntearUnAtuendoNoSeleccionadoException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.atuendo.Atuendo;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import ar.edu.utn.frba.dds.rest.DTOs.CalificacionDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
@RequestMapping(path = "calificaciones")
public class CalificacionesController {

    @GetMapping
    public List<Atuendo> findAll(@RequestHeader("Authorization") String token) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        List<Atuendo> respuesta = null;
        Usuario usuario = null;
        Session session = Autenticacion.getSession(token);
        usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        respuesta = usuario.getEventos().stream().map(Evento::getAtuendoElegido).filter(Objects::nonNull).collect(Collectors.toList());
        return respuesta;
    }

    @GetMapping(path = "{idAtuendo}")
    public Atuendo findOne(@RequestHeader("Authorization") String token, @PathVariable("idPrenda") Long idAtuendo) throws UserNotLoggedException, EntidadNoEncontradaException, NoSePuedePuntearUnAtuendoNoSeleccionadoException {
        Repositorio repo = Repositorio.getInstance();
        Evento evento = null;
        Atuendo respuesta = null;
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        evento = usuario.getEventos().stream().filter(eventofiltro -> eventofiltro.getAtuendoElegido().getId().equals(idAtuendo)).findFirst().orElse(null);
        if (evento == null) {
            throw new NoSePuedePuntearUnAtuendoNoSeleccionadoException();
        }

        respuesta = evento.getAtuendoElegido();

        if (respuesta == null) {
            throw new EntidadNoEncontradaException();
        }
        return respuesta;
    }

    @PostMapping
    public Atuendo AddOne(@RequestHeader("Authorization") String token, @RequestBody CalificacionDTO calificacionDTO) throws UserNotLoggedException, EntidadNoEncontradaException, NoSePuedePuntearUnAtuendoNoSeleccionadoException {
        Repositorio repo = Repositorio.getInstance();
        Atuendo respuesta = null;
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());

        Atuendo atuendo = usuario.getEventos().stream().map(Evento::getAtuendoElegido).filter(atuendoFilter -> atuendoFilter != null && atuendoFilter.getId().equals(calificacionDTO.getAtuendoID())).findFirst().orElse(null);
        if (atuendo == null) {
            throw new NoSePuedePuntearUnAtuendoNoSeleccionadoException();
        }

        atuendo.setCalificacion(calificacionDTO.getCalificacion());
        repo.persist(atuendo);
        respuesta = atuendo;
        return respuesta;
    }
}
