package ar.edu.utn.frba.dds.Autenticacion;

import java.util.Map;

public class Sessions {

    private static Map<String, Session> sessiones;

    public static Map<String, Session> getSessiones() {
        return sessiones;
    }

    public static void setSessiones(Map<String, Session> sessiones) {
        Sessions.sessiones = sessiones;
    }
}
