package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.Autenticacion.Sessions;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "logout")
public class LogoutController {

    @PostMapping
    public String logout(@RequestHeader("Authorization") String token) throws UserNotLoggedException {
        Autenticacion auth = new Autenticacion();
        Sessions.getSession(token);

        Sessions.getSessiones().remove(token);

        return String.format("{\"OK\":\"%s\"}", "1");
    }

}
