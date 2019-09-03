package ar.edu.utn.frba.dds.model;

import java.util.Arrays;

public class Atuendo {

    private Prenda prendaCalzado;
    private Prenda prendaInferior;
    private Prenda prendaSuperior;
    private Prenda abrigoLigero;
    private Prenda abrigoPesado;
    private Prenda prendaAccesorio;
    
    public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado, Prenda prendaAccesorio,
                   Prenda prendaAbrigoLigero, Prenda prendaAbrigoPesado) {
        this.abrigoLigero = prendaAbrigoLigero;
        this.abrigoPesado = prendaAbrigoPesado;
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.prendaCalzado = prendaCalzado;
        this.prendaAccesorio = prendaAccesorio;
    }

    public Double getNivelDeCalor(){
       return  Arrays.asList(prendaCalzado,prendaInferior,prendaSuperior,abrigoLigero,abrigoPesado,prendaAccesorio).stream().mapToDouble(x -> x.getTipoPrenda().getNivelDeCalor()).sum();
    }

    public Double getPuntaje(){
        return Arrays.asList(prendaCalzado,prendaInferior,prendaSuperior,abrigoLigero,abrigoPesado,prendaAccesorio).stream().mapToDouble(x -> x.getPuntaje()).sum();
    }

    @Override
    public String toString() {
        return "Atuendo{" +
                "prendaCalzado=" + prendaCalzado +
                ", prendaInferior=" + prendaInferior +
                ", prendaSuperior=" + prendaSuperior +
                ", abrigoLigero=" + abrigoLigero +
                ", abrigoPesado=" + abrigoPesado +
                ", prendaAccesorio=" + prendaAccesorio +
                '}';
    }
}
