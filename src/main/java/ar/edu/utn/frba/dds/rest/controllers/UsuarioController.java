package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuario;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioPremium;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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

    @DeleteMapping
    public Usuario deleteOne(@RequestHeader("Authorization") String token) throws EntidadNoEncontradaException, UserNotLoggedException {
        Repositorio repo = null;
        Usuario usuario = null;
        repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        repo.delete(usuario);
        Autenticacion.deleteSession(token);
        return usuario;
    }
}
