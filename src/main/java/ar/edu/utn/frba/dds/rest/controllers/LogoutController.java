package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.Autenticacion.Sessions;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path = "logout")
public class LogoutController {

    @PostMapping
    public String logout(@RequestHeader("Authorization") String token) throws UserNotLoggedException {
        Autenticacion auth = new Autenticacion();
        Autenticacion.getSession(token);

        Autenticacion.deleteSession(token);

        return String.format("{\"OK\":\"%s\"}", "1");
    }

}
