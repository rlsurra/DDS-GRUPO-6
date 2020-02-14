package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.atuendo.Atuendo;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import ar.edu.utn.frba.dds.rest.DTOs.EleccionDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "elegir")
public class EleccionController {

    @PostMapping
    public Evento AddOne(@RequestHeader("Authorization") String token, @RequestBody EleccionDTO eleccionDTO) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        Evento evento = null;

        if (eleccionDTO.getEventoid() == null) {
            throw new ParametrosInvalidosException("Debe seleccionar algun evento");
        }

        if (eleccionDTO.getAtuendoid() == null) {
            throw new ParametrosInvalidosException("Debe seleccionar algun atuendo");
        }

        evento = usuario.getEventos().stream().filter(evento1 -> evento1.getId().equals(eleccionDTO.getEventoid())).findFirst().orElse(null);

        if (evento == null) {
            throw new ParametrosInvalidosException("El usuario no puede acceder a ese evento");
        }

        Atuendo atuendo = evento.getPosiblesAtuendos().stream().filter(atuendo1 -> atuendo1.getId().equals(eleccionDTO.getAtuendoid())).findFirst().orElse(null);

        if (atuendo == null) {
            throw new ParametrosInvalidosException("Ese evento no tiene a ese atuendo entre sus sugerencias");
        }

        evento.setAtuendoElegido(atuendo);

        repo.save(evento);
        return evento;
    }
}

