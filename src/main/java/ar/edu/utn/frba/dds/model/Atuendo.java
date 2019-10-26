package ar.edu.utn.frba.dds.model;


import javax.persistence.*;
import java.util.Arrays;

@Entity(name = "atuendo")
@Table
public class Atuendo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = Prenda.class)
    @JoinColumn(name = "prenda_calzo_id")
    private Prenda prendaCalzado;

    @ManyToOne(targetEntity = Prenda.class)
    @JoinColumn(name = "prenda_inf_id")
    private Prenda prendaInferior;

    @ManyToOne(targetEntity = Prenda.class)
    @JoinColumn(name = "prenda_sup_id")
    private Prenda prendaSuperior;

    @ManyToOne(targetEntity = Prenda.class)
    @JoinColumn(name = "prenda_abr_lig_id")
    private Prenda abrigoLigero;

    @ManyToOne(targetEntity = Prenda.class)
    @JoinColumn(name = "prenda_abr_pes_id")
    private Prenda abrigoPesado;

    @ManyToOne(targetEntity = Prenda.class)
    @JoinColumn(name = "prenda_acce_id")
    private Prenda prendaAccesorio;


    public Atuendo() {
    }

    public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado, Prenda prendaAccesorio,
                   Prenda prendaAbrigoLigero, Prenda prendaAbrigoPesado) {
        this.abrigoLigero = prendaAbrigoLigero;
        this.abrigoPesado = prendaAbrigoPesado;
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.prendaCalzado = prendaCalzado;
        this.prendaAccesorio = prendaAccesorio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNivelDeCalor() {
        return Arrays.asList(prendaCalzado, prendaInferior, prendaSuperior, abrigoLigero, abrigoPesado, prendaAccesorio).stream().mapToDouble(x -> x.getTipoPrenda().getNivelDeCalor()).sum();
    }

    public Double getPuntaje() {
        return Arrays.asList(prendaCalzado, prendaInferior, prendaSuperior, abrigoLigero, abrigoPesado, prendaAccesorio).stream().mapToDouble(x -> x.getPuntaje()).sum();
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


    public Prenda getPrendaCalzado() {
        return prendaCalzado;
    }

    public void setPrendaCalzado(Prenda prendaCalzado) {
        this.prendaCalzado = prendaCalzado;
    }

    public Prenda getPrendaInferior() {
        return prendaInferior;
    }

    public void setPrendaInferior(Prenda prendaInferior) {
        this.prendaInferior = prendaInferior;
    }

    public Prenda getPrendaSuperior() {
        return prendaSuperior;
    }

    public void setPrendaSuperior(Prenda prendaSuperior) {
        this.prendaSuperior = prendaSuperior;
    }

    public Prenda getAbrigoLigero() {
        return abrigoLigero;
    }

    public void setAbrigoLigero(Prenda abrigoLigero) {
        this.abrigoLigero = abrigoLigero;
    }

    public Prenda getAbrigoPesado() {
        return abrigoPesado;
    }

    public void setAbrigoPesado(Prenda abrigoPesado) {
        this.abrigoPesado = abrigoPesado;
    }

    public Prenda getPrendaAccesorio() {
        return prendaAccesorio;
    }

    public void setPrendaAccesorio(Prenda prendaAccesorio) {
        this.prendaAccesorio = prendaAccesorio;
    }
}
