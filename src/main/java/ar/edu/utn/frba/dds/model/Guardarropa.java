package ar.edu.utn.frba.dds.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public​ ​List<Atuendo> ​generarSugerencia​()​ {
        return Sets
        ​.cartesianProduct(prendasSuperiores, prendasInferiores, calzados)
        .stream()
        .map((list) -> ​new​ Atuendo(list.get(​0​), list.get(​1​), list.get(​2​)))
        .collect(Collectors.toList());
    }


    }
