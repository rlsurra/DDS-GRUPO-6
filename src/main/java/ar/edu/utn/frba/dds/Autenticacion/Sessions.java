package ar.edu.utn.frba.dds.Autenticacion;

import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;

import java.util.HashMap;
import java.util.Map;

public class Sessions {

    private static Map<String, Session> sessiones = new HashMap<>();

    protected static Map<String, Session> getSessiones() {
        return sessiones;
    }

    protected static void setSessiones(Map<String, Session> sessiones) {
        Sessions.sessiones = sessiones;
    }

}
