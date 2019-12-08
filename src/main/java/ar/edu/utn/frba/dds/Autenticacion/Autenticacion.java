package ar.edu.utn.frba.dds.Autenticacion;

import ar.edu.utn.frba.dds.exceptions.InvalidCredentialsException;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.JPAUtils;
import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.EntityManager;

public class Autenticacion {

    public String login(String username, String password) throws InvalidCredentialsException {
        String token = null;
        EntityManager manager = null;
        try {
            manager = JPAUtils.getEntityManagerFactory().createEntityManager();

            Usuario user = Usuario.getUsuarioFromUserName(username);

            if (user == null){
                throw new InvalidCredentialsException();
            }

            if (!user.getPassword().equals(password)) {
                throw new InvalidCredentialsException();
            }

            token = new RandomString(32).nextString();

            Session session = new Session(token, user.getId());
            Sessions.getSessiones().put(token, session);
        } catch (InvalidCredentialsException e) {
            throw e;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }

        return token;
    }

    public void logout(String token) {
        Sessions.getSessiones().remove(token);
    }

}
