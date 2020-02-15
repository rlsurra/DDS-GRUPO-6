package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.GuardarropaUsuarioException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.PuntajePrenda;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Entidad;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import ar.edu.utn.frba.dds.rest.DTOs.PuntajeDTO;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
@RequestMapping(path = "puntajes")
public class PuntajesController {

    @GetMapping
    public List<PuntajePrenda> getTodosLosPuntajesDelUsuario(@RequestHeader("Authorization") String token) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());

        List<PuntajePrenda> puntajes = new ArrayList<>();
        for (Guardarropa guardarropa : usuario.getGuardarropas()){
            for (Prenda prenda : guardarropa.getPrendas()){
                PuntajePrenda puntajePrendaDelUsuario = prenda.getPuntajePrendaDelUsuario(usuario);
                if (puntajePrendaDelUsuario != null) {
                    puntajes.add(puntajePrendaDelUsuario);
                }
            }
        }
        return puntajes;
    }

    @GetMapping(path = "{idPrenda}")
    public Double getPuntajeDeUnaPrenda(@RequestHeader("Authorization") String token, @PathVariable("idPrenda") Long idPrenda) throws UserNotLoggedException, EntidadNoEncontradaException {
        Repositorio repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());

        Prenda prenda = repo.getEntidadById(Prenda.class, idPrenda);
        if (prenda == null) {
            throw new EntidadNoEncontradaException();
        }
        return prenda.getPuntajeDeUsuario(usuario);
    }

    @PostMapping
    public Double agregarPuntajeAUnaPrenda(@RequestHeader("Authorization") String token, @RequestBody PuntajeDTO puntajeDTO) throws UserNotLoggedException, EntidadNoEncontradaException {
        Repositorio repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());

        Prenda prendaAPuntuar = repo.getEntidadById(Prenda.class, Long.valueOf(puntajeDTO.getPrendaid()));
        if (prendaAPuntuar == null) {
            throw new EntidadNoEncontradaException();
        }

        boolean esPrendaDelUsuario = Boolean.FALSE;
        for (Guardarropa guardarropa : usuario.getGuardarropas()){
            for (Prenda prenda : guardarropa.getPrendas()){
                if (prenda.getId().equals(prendaAPuntuar.getId())){
                    esPrendaDelUsuario = Boolean.TRUE;
                }
            }
        }

        if (!esPrendaDelUsuario) {
            throw new GuardarropaUsuarioException("La prenda a puntuar no pertenece al usuario");
        }

        prendaAPuntuar.setPuntaje(usuario, Double.valueOf(puntajeDTO.getPuntaje()));
        repo.update(prendaAPuntuar);
        return prendaAPuntuar.getPuntajeDeUsuario(usuario);
    }
}
