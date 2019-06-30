package ar.edu.utn.frba.dds.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public List<Guardarropa> getGuardarropas() {
        return guardarropas;
    }

    private List<Guardarropa> guardarropas = new ArrayList<>();

    public void agregarGuardarropa(Guardarropa guardarropa){
        guardarropas.add(guardarropa);
    }

}
