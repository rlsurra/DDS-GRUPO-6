package ar.edu.utn.frba.dds.Autenticacion;

import ar.edu.utn.frba.dds.exceptions.InvalidCredentialsException;
import ar.edu.utn.frba.dds.model.usuario.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Autenticacion {

    public String login(String username, String password) throws InvalidCredentialsException {
        String token = null;

        EntityManager manager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
        Usuario user = (Usuario) manager.createNativeQuery("SELECT * FROM User WHERE username = " + username).getSingleResult();

        if (user == null){
            throw new InvalidCredentialsException();
        }

        if (!user.getPassword().equals(password)){
            throw new InvalidCredentialsException();
        }

        token = new RandomString(32).nextString();

        new Session(token, user);

        return token;
    }

    public void logout(String token){
        Sessions.getSessiones().remove(token);
    }

}
