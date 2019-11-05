package ar.edu.utn.frba.dds.Autenticacion;

import ar.edu.utn.frba.dds.exceptions.InvalidCredentialsException;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Autenticacion {

    public String login(String username, String password) throws InvalidCredentialsException {
        String token = null;

        EntityManager manager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
        Long idusuario = ((Number) manager.createNativeQuery("SELECT id FROM Usuario WHERE username = '" + username + "'"
        ).getSingleResult()).longValue();

        Repositorio repo = new Repositorio(manager);
        Usuario user = repo.getEntidadById(Usuario.class, idusuario);

        if (!user.getPassword().equals(password)){
            throw new InvalidCredentialsException();
        }

        token = new RandomString(32).nextString();

        Session session = new Session(token, user);
        Sessions.getSessiones().put(token, session);

        return token;
    }

    public void logout(String token){
        Sessions.getSessiones().remove(token);
    }

}
