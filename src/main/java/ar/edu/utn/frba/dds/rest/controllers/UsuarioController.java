package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.rest.service.RepositorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private RepositorioService repo;

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return repo.crearUsuario(usuario);
    }

}
