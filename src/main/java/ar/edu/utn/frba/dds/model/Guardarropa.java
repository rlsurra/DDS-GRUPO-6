package ar.edu.utn.frba.dds.model;

import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Guardarropa {

    private List<Prenda> prendasSuperiores = new ArrayList<>();
    private List<Prenda> prendasInferiores = new ArrayList<>();
    private List<Prenda> prendasCalzado = new ArrayList<>();
    private List<Prenda> prendasAccesorio = new ArrayList<>();

    /*
    getters
     */
    public List<Prenda> getPrendasSuperiores() {
        return prendasSuperiores;
    }

    public List<Prenda> getPrendasInferiores() {
        return prendasInferiores;
    }

    public List<Prenda> getPrendasCalzado() {
        return prendasCalzado;
    }

    public List<Prenda> getPrendasAccesorio() {
        return prendasAccesorio;
    }

    /*
    setters
     */
    public void setPrendasSuperiores(List<Prenda> prendasSuperiores) {
        this.prendasSuperiores = prendasSuperiores;
    }

    public void setPrendasInferiores(List<Prenda> prendasInferiores) {
        this.prendasInferiores = prendasInferiores;
    }

    public void setPrendasCalzado(List<Prenda> prendasCalzado) {
        this.prendasCalzado = prendasCalzado;
    }

    public void setPrendasAccesorio(List<Prenda> prendasAccesorio) {
        this.prendasAccesorio = prendasAccesorio;
    }

    public List<Atuendo> generarSugerencias(){
    return
       Sets.cartesianProduct(Sets.newHashSet(prendasSuperiores), Sets.newHashSet(prendasInferiores),
                Sets.newHashSet(prendasCalzado), Sets.newHashSet(prendasAccesorio))
                .stream()
                .map(list -> new Atuendo(list.get(0), list.get(1), list.get(2), list.get(3)))
                .collect(Collectors.toList());
    }

    public Atuendo getSugerenciaAleatoria(){
        List<Atuendo> sugerencias = generarSugerencias();
        return sugerencias.get(new Random().nextInt(sugerencias.size()));
    }



    }
