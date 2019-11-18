package ar.edu.utn.frba.dds.Autenticacion;

import ar.edu.utn.frba.dds.exceptions.InvalidCredentialsException;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.JPAUtils;
import ar.edu.utn.frba.dds.persistence.Repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class Autenticacion {

    public String login(String username, String password) throws InvalidCredentialsException {
        String token = null;
        EntityManager manager = null;
        try {
            manager = JPAUtils.getEntityManagerFactory().createEntityManager();
            Long idusuario = ((Number) manager.createNativeQuery("SELECT id FROM Usuario WHERE username = '" + username + "'"
            ).getSingleResult()).longValue();

            Repositorio repo = new Repositorio(manager);
            Usuario user = repo.getEntidadById(Usuario.class, idusuario);

            if (!user.getPassword().equals(password)) {
                throw new InvalidCredentialsException();
            }

            token = new RandomString(32).nextString();

            Session session = new Session(token, user.getId());
            Sessions.getSessiones().put(token, session);
        } catch (InvalidCredentialsException e){
            throw e;
        } finally {
            if (manager != null){
                manager.close();
            }
        }

        return token;
    }

    public void logout(String token){
        Sessions.getSessiones().remove(token);
    }

}
