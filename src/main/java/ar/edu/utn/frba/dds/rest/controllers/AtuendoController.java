package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.GuardarropaUsuarioException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.atuendo.Atuendo;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path = "atuendos")
public class AtuendoController {

    @GetMapping
    public List<Atuendo> generarAtuendosDelGuardarropa(@RequestHeader("Authorization") String token, @RequestParam(name = "guardarropa") Long guardarropaid,
                                                       @RequestParam(name = "evento") Long eventoid ) throws UserNotLoggedException, EntidadNoEncontradaException {

        Repositorio repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);

        Guardarropa guardarropa = repo.getEntidadById(Guardarropa.class, guardarropaid);
        Evento evento = repo.getEntidadById(Evento.class, eventoid);
        if (guardarropa == null) {
            throw new EntidadNoEncontradaException("No es posible encontrar el Guardarropa indicado");
        }
        if (evento == null) {
            throw new EntidadNoEncontradaException("No es posible encontrar el Evento indicado");
        }

        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        List<Guardarropa> guardarropasDelUsuario = usuario.getGuardarropas();

        esDelUsuario(guardarropasDelUsuario, guardarropa);

//        return guardarropa.generarSugerencias(usuario, evento);
        return guardarropa.generarSugerenciasPosibles();

    }

    private void esDelUsuario(List<Guardarropa> guardarropas, Guardarropa guardarropa){
        boolean esDelUsuario = Boolean.FALSE;
        for (Guardarropa g : guardarropas) {
            if (g.getId().equals(guardarropa.getId())){
                esDelUsuario = Boolean.TRUE;
            }
        }
        if (!esDelUsuario){
            throw new GuardarropaUsuarioException("El usuario no posee el guardarropa indicado");
        }
    }

}