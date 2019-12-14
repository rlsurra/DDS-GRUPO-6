package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import ar.edu.utn.frba.dds.rest.DTOs.PrendaDTO;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "prendas")
public class PrendasController {

    @GetMapping
    public List<Prenda> findAll(@RequestHeader("Authorization") String token, @RequestParam(required = false, name = "guardarropaid") Long guardarropaid) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        List<Prenda> respuesta = new ArrayList<Prenda>();
        Usuario usuario = null;
        Session session = Autenticacion.getSession(token);
        usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        List<Guardarropa> guardarropas = usuario.getGuardarropas();
        if (guardarropaid == null){
            guardarropas.forEach(guardarropa -> {
                respuesta.addAll(guardarropa.getPrendas());});
        } else {
            for (Guardarropa guard : guardarropas){
                if (guard.getId().equals(guardarropaid)){
                    respuesta.addAll(guard.getPrendas());
                }
            }
        }
        return respuesta;
    }

    @GetMapping(path = "{id}")
    public Prenda findOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id) throws UserNotLoggedException, EntidadNoEncontradaException {
        Repositorio repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        for (Guardarropa guardarropa : usuario.getGuardarropas()){
            for (Prenda prenda : guardarropa.getPrendas()){
                if (prenda.getId().equals(id)){
                    return prenda;
                }
            }
        }
        throw new EntidadNoEncontradaException();
    }

    @PutMapping
    public Prenda RefreshOne(@RequestHeader("Authorization") String token, @RequestBody Prenda prenda) throws UserNotLoggedException, EntidadNoEncontradaException {
        Repositorio repo = Repositorio.getInstance();
        Prenda respuesta = null;
        Prenda prendaOld = null;
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        if (prenda.getId() == null){
            throw new ParametrosInvalidosException("Debe enviar el id de su prenda a actualizar");
        }
        for (Guardarropa guardarropa : usuario.getGuardarropas()){
            for (Prenda prendaBusq : guardarropa.getPrendas()){
                if (prendaBusq.getId().equals(prenda.getId())){
                    prendaOld = prendaBusq;
                }
            }
        }

        if (prendaOld == null) {
            throw new EntidadNoEncontradaException();
        }
        prendaOld.update(prenda);
        respuesta = prendaOld;
        return respuesta;
    }

    @PostMapping
    public Prenda AddOne(@RequestHeader("Authorization") String token, @RequestBody PrendaDTO prendaDto) throws UserNotLoggedException {
        Repositorio repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        boolean ok = Boolean.FALSE;

        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());
        Guardarropa guardarropaDTO = repo.getEntidadById(Guardarropa.class, Long.valueOf(prendaDto.getGuardarropaID()));
        if (guardarropaDTO == null){
            throw new ParametrosInvalidosException("La prenda debe pertenecer a un guardarropa");
        }
        TipoPrenda tipoPrendaDTO = repo.getEntidadById(TipoPrenda.class, Long.valueOf(prendaDto.getTipoPrendaID()));

        Prenda nuevaPrenda = new Prenda();
        //Color, imagen de TEST
        nuevaPrenda.setColorPrimario(null);
        nuevaPrenda.setImagenPrenda(prendaDto.getImagenUrl());
        nuevaPrenda.setNombre(prendaDto.getNombrePrenda());
        nuevaPrenda.setTipoPrenda(tipoPrendaDTO);
        nuevaPrenda.setGuardarropaActual(guardarropaDTO);

        for (Guardarropa guardarropa : usuario.getGuardarropas()) {
            if (guardarropa.getId().equals(guardarropaDTO.getId())) {
                guardarropa.getPrendas().add(nuevaPrenda);
                repo.savePrenda(nuevaPrenda);
                repo.update(guardarropa);
                ok = true;
            }
        }

        if (!ok) {
            throw new RuntimeException("No se guardo la prenda porque no posees el guardarropa indicado");
        }

        return repo.getEntidadById(Prenda.class, nuevaPrenda.getId());
    }

    @DeleteMapping(path = "{id}")
    public Prenda deleteOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id) throws EntidadNoEncontradaException, UserNotLoggedException {
        Repositorio repo = null;
        Prenda respuesta = null;
        repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());

        for (Guardarropa guardarropa : usuario.getGuardarropas()){
            for (Prenda prendaBusq : guardarropa.getPrendas()){
                if (prendaBusq.getId().equals(id)){
                    respuesta = prendaBusq;
                    guardarropa.getPrendas().remove(respuesta);
                }
            }
        }

        if (respuesta == null) {
            throw new EntidadNoEncontradaException();
        }

        repo.save(usuario);
        repo.delete(respuesta);
        return respuesta;
    }
}
