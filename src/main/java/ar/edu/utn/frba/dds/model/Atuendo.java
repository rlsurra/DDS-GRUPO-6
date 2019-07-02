package ar.edu.utn.frba.dds.model;

public class Atuendo {

    private Prenda prendaCalzado;
    private Prenda prendaInferior;
    private Prenda prendaSuperior;
    private Prenda abrigoLiviano;
    private Prenda abrigoPesado;
    private Prenda prendaAccesorio;
    
    public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado, Prenda prendaAccesorio) {
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.prendaCalzado = prendaCalzado;
        this.prendaAccesorio = prendaAccesorio;
    }

    @Override
    public String toString() {
        return System.getProperty("line.separator") +"Atuendo { " + System.getProperty("line.separator") +
                "prendaSuperior=" + prendaSuperior +
                ", prendaInferior=" + prendaInferior +
                ", prendaCalzado=" + prendaCalzado +
                ", prendaAccesorio=" + prendaAccesorio +
                '}' + System.getProperty("line.separator") ;
    }
}
