package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Credenciales;
import ar.edu.utn.frba.dds.exceptions.InvalidCredentialsException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path = "login")
public class LoginController {

    @PostMapping
    public String login(@RequestBody Credenciales credenciales) throws InvalidCredentialsException {
        Autenticacion auth = new Autenticacion();
        String token = null;
        try {
            token = auth.login(credenciales.getUsername(), credenciales.getPassword());
        } catch (Exception e) {
            throw e;
        }
        return String.format("{\"token\":\"%s\"}", token);
    }

}
