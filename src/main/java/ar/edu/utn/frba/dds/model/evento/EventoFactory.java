package ar.edu.utn.frba.dds.model.evento;

import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;

public class EventoFactory {

    public static Evento getEvento(String tipo){
        Evento evento = null;

        switch (tipo){
            case "SIMPLE":
                evento = new EventoSimple();
                break;
            default:
                throw new ParametrosInvalidosException("No existe ese tipo de evento");
        }

        return evento;
    }

}
