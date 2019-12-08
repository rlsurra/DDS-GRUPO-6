package ar.edu.utn.frba.dds.exceptions;

public class InvalidCredentialsException extends Exception {

    public InvalidCredentialsException(){
        super("Su usuario o password son invalidos");
    }
}
