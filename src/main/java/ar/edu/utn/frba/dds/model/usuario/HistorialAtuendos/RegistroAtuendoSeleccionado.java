package ar.edu.utn.frba.dds.model.usuario.HistorialAtuendos;

import ar.edu.utn.frba.dds.model.atuendo.Atuendo;
import ar.edu.utn.frba.dds.model.evento.Evento;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Entidad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

@Entity
public class RegistroAtuendoSeleccionado extends Entidad {

    @ManyToOne(cascade = CascadeType.MERGE)
    private Usuario usuario;

    @Column
    private LocalTime fecha;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Atuendo atuendo;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Evento evento;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalTime fecha) {
        this.fecha = fecha;
    }

    public Atuendo getAtuendo() {
        return atuendo;
    }

    public void setAtuendo(Atuendo atuendo) {
        this.atuendo = atuendo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
