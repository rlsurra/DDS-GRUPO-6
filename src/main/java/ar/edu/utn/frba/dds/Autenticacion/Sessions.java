package ar.edu.utn.frba.dds.Autenticacion;

import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;

import java.util.HashMap;
import java.util.Map;

public class Sessions {

    private static Map<String, Session> sessiones = new HashMap<>();

    public static Map<String, Session> getSessiones() {
        return sessiones;
    }

    public static void setSessiones(Map<String, Session> sessiones) {
        Sessions.sessiones = sessiones;
    }

    public static void checkSession(String token) throws UserNotLoggedException {
        if (!getSessiones().containsKey(token)){
            throw new UserNotLoggedException();
        }
    };

    public static Session getSession(String token) throws UserNotLoggedException {
        checkSession(token);
        return getSessiones().get(token);
    };

}
