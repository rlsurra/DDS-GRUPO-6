package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
@RequestMapping(path = "tiposPrenda")
public class TiposPrendaController {

    @GetMapping
    public List<TipoPrenda> findAll(@RequestHeader("Authorization") String token) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        List<TipoPrenda> respuesta = null;
        Usuario usuario = null;
        Session session = Autenticacion.getSession(token);
        return TipoPrenda.findall();
    }
}
