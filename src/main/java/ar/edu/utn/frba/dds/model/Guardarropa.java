package ar.edu.utn.frba.dds.model;

import java.util.ArrayList;
import java.util.List;

public class Guardarropa {

    private List<Prenda> prendas = new ArrayList<>();
    private GeneradorDeAtuendos generadorDeAtuendos = GeneradorDeAtuendos.getInstance();

    public Guardarropa(){

    }

    public List<Prenda> getPrendas() {
        return prendas;
    }

    public void setPrendas(List<Prenda> prendas) {
        this.prendas = prendas;
    }


    public void getAtuendo() {
        //TODO: Aca va a estar la magia para generar los atuendos,
        // En el futuro, deberia poder pasarse un parametro para definir que tipo de atuendo generar
        generadorDeAtuendos.generarAtuendos(prendas);
    }
}
