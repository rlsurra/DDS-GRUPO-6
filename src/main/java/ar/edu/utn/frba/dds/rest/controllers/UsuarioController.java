package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.rest.service.RepositorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private RepositorioService repo;

    @PostMapping
    public Usuario crearUsuario() {
        return repo.crearUsuario();
    }

}
