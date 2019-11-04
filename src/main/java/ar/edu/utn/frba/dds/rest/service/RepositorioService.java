package ar.edu.utn.frba.dds.rest.service;

import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuario;
import ar.edu.utn.frba.dds.model.usuario.tipoUsuario.TipoUsuarioPremium;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

@Repository
public class RepositorioService {

    private Repositorio repositorio;

    public RepositorioService() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
        repositorio = new Repositorio(emFactory.createEntityManager());
    }

    public Usuario crearUsuario(){
        Usuario usuario = new Usuario();
        usuario.setGuardarropas(new ArrayList<>());
        TipoUsuario tipoUsuarioPremium = new TipoUsuarioPremium();
        usuario.setTipoUsuario(tipoUsuarioPremium);
        usuario.setId(null);

        repositorio.save(usuario);

        return repositorio.getEntidadById(Usuario.class, usuario.getId());
    }
}
