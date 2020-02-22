package ar.edu.utn.frba.dds.model.atuendo;


import ar.edu.utn.frba.dds.persistence.Entidad;
import ar.edu.utn.frba.dds.model.prenda.Prenda;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.stream.Stream;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "atuendo")
@Table
public class Atuendo extends Entidad {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column
    private Long calificacion;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(targetEntity = Prenda.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "prenda_calzo_id")
    private Prenda prendaCalzado;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(targetEntity = Prenda.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "prenda_inf_id")
    private Prenda prendaInferior;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(targetEntity = Prenda.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "prenda_sup_id")
    private Prenda prendaSuperior;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(targetEntity = Prenda.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "prenda_abr_lig_id")
    private Prenda abrigoLigero;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(targetEntity = Prenda.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "prenda_abr_pes_id")
    private Prenda abrigoPesado;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(targetEntity = Prenda.class, cascade = CascadeType.PERSIST)
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

    public Double getNivelDeCalor() {
        return Stream.of(prendaCalzado, prendaInferior, prendaSuperior, abrigoLigero, abrigoPesado, prendaAccesorio).mapToDouble(x -> x.getTipoPrenda().getNivelDeCalor()).sum();
    }

    public Double getPuntaje(Usuario usuario) {
        return Stream.of(prendaCalzado, prendaInferior, prendaSuperior, abrigoLigero, abrigoPesado, prendaAccesorio).mapToDouble(x -> x.getPuntajeDeUsuario(usuario)).sum();
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


    public Long getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }
}
