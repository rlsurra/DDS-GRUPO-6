package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.PuntajePrenda;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Entidad;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
@RequestMapping(path = "puntajes")
public class PuntajesController {

    @GetMapping
    public List<PuntajePrenda> findAll(@RequestHeader("Authorization") String token) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        List<PuntajePrenda> respuesta = null;
        Usuario usuario = null;
        Session session = Autenticacion.getSession(token);
        usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        respuesta = usuario.getPuntajes();
        return respuesta;
    }

    @GetMapping(path = "{idPrenda}")
    public PuntajePrenda findOne(@RequestHeader("Authorization") String token, @PathVariable("idPrenda") Long idPrenda) throws UserNotLoggedException, EntidadNoEncontradaException {
        Repositorio repo = Repositorio.getInstance();
        PuntajePrenda respuesta = null;
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        respuesta = usuario.getPuntajes().stream().filter(puntaje -> puntaje.getPrenda().getId().equals(idPrenda)).findFirst().orElse(null);
        if (respuesta == null) {
            throw new EntidadNoEncontradaException();
        }
        return respuesta;
    }

    @PostMapping
    public PuntajePrenda AddOne(@RequestHeader("Authorization") String token, @RequestBody PuntajePrenda puntaje) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        PuntajePrenda respuesta = null;
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        final Long prendaid = puntaje.getPrenda().getId();
        if (usuario.obtenerTodasLasPrendas().stream().map(Entidad::getId).collect(Collectors.toList()).contains(prendaid)){
            Prenda prendaPuntuada = usuario.obtenerTodasLasPrendas().stream().filter(prenda -> prenda.getId().equals(prendaid)).findFirst().orElse(null);
            puntaje.setPrenda(prendaPuntuada);
        }

        if (usuario.getPuntajes().stream().anyMatch(puntajeU -> puntajeU.getPrenda().getId().equals(puntaje.getPrenda().getId()))){
            PuntajePrenda puntajeActual = usuario.getPuntajes().stream().filter((puntajeU -> puntajeU.getPrenda().getId().equals(puntaje.getPrenda().getId()))).findFirst().orElse(null);
            usuario.getPuntajes().remove(puntajeActual);
        }
        usuario.getPuntajes().add(puntaje);
        puntaje.setUsuario(usuario);
        repo.save(usuario);
        respuesta = repo.getEntidadById(PuntajePrenda.class, puntaje.getId());
        return respuesta;
    }
}
