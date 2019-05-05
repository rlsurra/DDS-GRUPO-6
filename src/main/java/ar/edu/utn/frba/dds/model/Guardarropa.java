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

    public List<Atuendo> getAtuendos() {
        return generadorDeAtuendos.generarAtuendos(prendas);
    }
}
