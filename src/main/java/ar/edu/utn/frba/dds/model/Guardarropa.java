package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.model.prenda.TipoPrendaAccesorio;
import ar.edu.utn.frba.dds.model.prenda.TipoPrendaCalzado;
import ar.edu.utn.frba.dds.model.prenda.TipoPrendaInferior;
import ar.edu.utn.frba.dds.model.prenda.TipoPrendaSuperior;

import java.util.ArrayList;
import java.util.List;

public class Guardarropa {

    private List<TipoPrendaSuperior> prendasSuperiores = new ArrayList<>();
    private List<TipoPrendaInferior> prendasInferiores = new ArrayList<>();
    private List<TipoPrendaCalzado> prendasCalzado = new ArrayList<>();
    private List<TipoPrendaAccesorio> prendasAccesorio = new ArrayList<>();

    private GeneradorDeAtuendos generadorDeAtuendos = GeneradorDeAtuendos.getInstance();

    /*
    getters
     */
    public List<TipoPrendaSuperior> getPrendasSuperiores() {
        return prendasSuperiores;
    }

    public List<TipoPrendaInferior> getPrendasInferiores() {
        return prendasInferiores;
    }

    public List<TipoPrendaCalzado> getPrendasCalzado() {
        return prendasCalzado;
    }

    public List<TipoPrendaAccesorio> getPrendasAccesorio() {
        return prendasAccesorio;
    }

    /*
    setters
     */
    public void setPrendasSuperiores(List<TipoPrendaSuperior> prendasSuperiores) {
        this.prendasSuperiores = prendasSuperiores;
    }

    public void setPrendasInferiores(List<TipoPrendaInferior> prendasInferiores) {
        this.prendasInferiores = prendasInferiores;
    }

    public void setPrendasCalzado(List<TipoPrendaCalzado> prendasCalzado) {
        this.prendasCalzado = prendasCalzado;
    }

    public void setPrendasAccesorio(List<TipoPrendaAccesorio> prendasAccesorio) {
        this.prendasAccesorio = prendasAccesorio;
    }
}
