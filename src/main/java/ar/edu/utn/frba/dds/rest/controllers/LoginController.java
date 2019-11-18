package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Credenciales;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.InvalidCredentialsException;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.rest.service.RepositorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="login")
public class LoginController {

    @PostMapping
    public String login(@RequestBody Credenciales credenciales) throws InvalidCredentialsException {
        Autenticacion auth = new Autenticacion();
        String token = null;
        try {
            token = auth.login(credenciales.getUsername(), credenciales.getPassword());
        } catch (Exception e){
            throw e;
        }
        return String.format("{\"token\":\"%s\"}", token);
    }

}
