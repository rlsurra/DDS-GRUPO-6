package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Credenciales;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.Autenticacion.Sessions;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.rest.service.RepositorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="logout")
public class LogoutController {

    @PostMapping
    public String logout(@RequestHeader("Authorization") String token) throws UserNotLoggedException {
        Autenticacion auth = new Autenticacion();
        Session session = Sessions.getSessiones().get(token);

        if (session == null || session.getUsuarioId() == null){
            throw new UserNotLoggedException();
        }

        Sessions.getSessiones().remove(token);

        return String.format("{\"OK\":\"%s\"}", "1");
    }

}
