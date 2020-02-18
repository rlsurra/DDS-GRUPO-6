package ar.edu.utn.frba.dds.exceptions;

public class EntidadNoEncontradaException extends Exception {

    public EntidadNoEncontradaException(){
        super("La entidad buscada no se encuentra");
    }

    public EntidadNoEncontradaException(String msj){
        super(msj);
    }

}
