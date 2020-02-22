package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.atuendo.Atuendo;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import ar.edu.utn.frba.dds.rest.DTOs.EleccionDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
@RequestMapping(path = "elegir")
public class EleccionController {

    @PostMapping
    public Evento AddOne(@RequestHeader("Authorization") String token, @RequestBody EleccionDTO eleccionDTO) throws UserNotLoggedException, EntidadNoEncontradaException {
        Repositorio repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());

        if (eleccionDTO.getEventoid() == null) {
            throw new ParametrosInvalidosException("Debe seleccionar algun evento");
        }

        if (eleccionDTO.getAtuendoid() == null) {
            throw new ParametrosInvalidosException("Debe seleccionar algun atuendo");
        }

        Evento eventoBBDD = repo.getEntidadById(Evento.class, eleccionDTO.getEventoid());
        if (eventoBBDD == null) {
            throw new EntidadNoEncontradaException("No es posible encontrar el Evento indicado");
        }


        Evento eventoJava = usuario.getEventos().stream().filter(evento1 -> evento1.getId().equals(eventoBBDD.getId())).findFirst().orElse(null);
        if (eventoJava == null) {
            throw new ParametrosInvalidosException("El usuario no puede acceder a ese evento");
        }

        Atuendo atuendo = eventoJava.getPosiblesAtuendos().stream().filter(atuendo1 -> atuendo1.getId().equals(eleccionDTO.getAtuendoid())).findFirst().orElse(null);
        if (atuendo == null) {
            throw new ParametrosInvalidosException("Ese evento no tiene a ese atuendo entre sus sugerencias");
        }

        eventoBBDD.setAtuendoElegido(atuendo);
        repo.persist(eventoBBDD);
        return eventoBBDD;
    }
}

