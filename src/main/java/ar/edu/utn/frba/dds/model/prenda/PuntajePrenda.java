package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.persistence.Entidad;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class PuntajePrenda extends Entidad {

    @ManyToOne(targetEntity = Usuario.class, cascade = CascadeType.MERGE)
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne(targetEntity = Prenda.class, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"tipoPrenda", "material", "colorPrimario", "colorSecundario", "imagenPrenda", "guardarropaActual"})
    private Prenda prenda;

    @Column
    private Double puntaje;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @JsonIgnore
    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

}
