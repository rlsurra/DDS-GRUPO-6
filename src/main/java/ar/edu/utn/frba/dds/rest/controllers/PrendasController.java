package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.Autenticacion.Session;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.GuardarropaUsuarioException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import ar.edu.utn.frba.dds.rest.DTOs.PrendaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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

    //TODO: Ver si esta bien devolver entidad no encontrada cuando no pertenece al usuario la prenda buscada
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

    @PutMapping(path = "{id}")
    public Prenda RefreshOne(@RequestHeader("Authorization") String token, @PathVariable("id") Long id, @RequestBody PrendaDTO prendaDto) throws UserNotLoggedException, EntidadNoEncontradaException {

        Repositorio repo = Repositorio.getInstance();
        Session session = Autenticacion.getSession(token);
        Usuario usuario = repo.getEntidadById(Usuario.class, session.getUsuarioId());

        Prenda prendaOld = repo.getEntidadById(Prenda.class, id);
        if (prendaOld == null){
            throw new EntidadNoEncontradaException();
        }

        boolean esPrendaDelUsuario = Boolean.FALSE;
        for (Guardarropa guardarropa : usuario.getGuardarropas()){
            for (Prenda prenda : guardarropa.getPrendas()){
                if (prenda.getId().equals(prendaOld.getId())){
                    esPrendaDelUsuario = Boolean.TRUE;
                }
            }
        }

        if (!esPrendaDelUsuario) {
            throw new GuardarropaUsuarioException("La prenda no esta en ningun guardarropa del usuario");
        }

        if (prendaDto.getTipoPrendaID() != null) {
            TipoPrenda nuevoTipo = repo.getEntidadById(TipoPrenda.class, Long.valueOf(prendaDto.getTipoPrendaID()));
            if (nuevoTipo == null) {
                throw new ParametrosInvalidosException("Debe ingresar un Tipo de Prenda valido");
            }
            prendaOld.setTipoPrenda(nuevoTipo);
        }

        if (prendaDto.getMaterialId() != null) {
            Material nuevoMaterial = repo.getEntidadById(Material.class, Long.valueOf(prendaDto.getMaterialId()));
            if (nuevoMaterial == null) {
                throw new ParametrosInvalidosException("Debe ingresar un Material valido");
            }
            prendaOld.setMaterial(nuevoMaterial);
        }

        if (prendaDto.getGuardarropaID() != null) {
            Guardarropa nuevoGuardarropa = repo.getEntidadById(Guardarropa.class, Long.valueOf(prendaDto.getGuardarropaID()));
            if (nuevoGuardarropa == null) {
                throw new ParametrosInvalidosException("Debe ingresar un Guardarropa valido");
            }

            boolean esGuardarropaDelUsuario = Boolean.FALSE;
            for (Guardarropa guardarropa : usuario.getGuardarropas()){
                if (guardarropa.getId().equals(nuevoGuardarropa.getId())) {
                    esGuardarropaDelUsuario = Boolean.TRUE;
                }
            }
            if (!esGuardarropaDelUsuario) {
                throw new GuardarropaUsuarioException("El nuevo guardarropa no pertenece al usuario");
            }
            prendaOld.setGuardarropaActual(nuevoGuardarropa);
        }

        if (prendaDto.getNombrePrenda() != null) {
            prendaOld.setNombre(prendaDto.getNombrePrenda());
        }


        //TODO: Ver como actualizar los colores, porque deberia recibir string y setearlo
        if (prendaDto.getColorPrincipal() != null) {
        }

        if (prendaDto.getColorSecundario() != null) {
        }

        repo.update(prendaOld);
        return prendaOld;
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
        Material materialPrendaDTO = repo.getEntidadById(Material.class, Long.valueOf(prendaDto.getMaterialId()));

        Prenda nuevaPrenda = new Prenda();
        //Color, imagen de TEST
        nuevaPrenda.setColorPrimario(prendaDto.getColorPrincipal());
        nuevaPrenda.setColorSecundario(prendaDto.getColorSecundario());
        nuevaPrenda.setNombre(prendaDto.getNombrePrenda());
        nuevaPrenda.setTipoPrenda(tipoPrendaDTO);
        nuevaPrenda.setGuardarropaActual(guardarropaDTO);
        nuevaPrenda.setMaterial(materialPrendaDTO);

        for (Guardarropa guardarropa : usuario.getGuardarropas()) {
            if (guardarropa.getId().equals(guardarropaDTO.getId())) {
                guardarropa.getPrendas().add(nuevaPrenda);
                repo.persist(nuevaPrenda);
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
