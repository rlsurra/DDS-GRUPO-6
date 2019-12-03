package ar.edu.utn.frba.dds.exceptions;

public class UserNotLoggedException extends Exception {

    public UserNotLoggedException(){
        super("Usted no se encuentra loggeado");
    }

}
