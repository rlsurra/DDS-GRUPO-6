package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuario;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioPremium;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        Repositorio repositorio = Repositorio.getInstance();
        usuario.setGuardarropas(new ArrayList<>());
        TipoUsuario tipoUsuarioPremium = new TipoUsuarioPremium();
        usuario.setTipoUsuario(tipoUsuarioPremium);
        repositorio.save(usuario);

        return repositorio.getEntidadById(Usuario.class, usuario.getId());
    }

}
