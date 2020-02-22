package ar.edu.utn.frba.dds.exceptions;

public class MaximaCantidadPrendasException extends RuntimeException {
    public MaximaCantidadPrendasException() {
        super("Se superó límite máximo de prendas permitidas");
    }
}
