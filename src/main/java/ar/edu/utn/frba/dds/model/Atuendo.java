package ar.edu.utn.frba.dds.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Atuendo {

    private Prenda prendaSuperior;
    private Prenda prendaInferior;
    private Prenda prendaCalzado;
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
