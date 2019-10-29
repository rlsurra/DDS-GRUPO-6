package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.Persistible;
import ar.edu.utn.frba.dds.model.usuario.Usuario;

import javax.persistence.*;

@Entity
public class PuntajePrenda extends Persistible {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL)
    private Usuario usuario;

    @ManyToOne(targetEntity = Prenda.class, cascade = CascadeType.ALL)
    private Prenda prenda;

    @Column
    private Double puntaje;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
