package ar.edu.utn.frba.dds.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private List<Guardarropa> guardarropas = new ArrayList<Guardarropa>();

    public void getAtuendo(Guardarropa guardarropa){
        guardarropa.getAtuendo();
    }
}
