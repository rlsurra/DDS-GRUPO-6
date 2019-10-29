package ar.edu.utn.frba.dds.model.evento;

import ar.edu.utn.frba.dds.Persistible;
import ar.edu.utn.frba.dds.model.Atuendo;
import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorAplicacion;
import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorEvento;
import ar.edu.utn.frba.dds.model.usuario.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "evento")
public class Evento extends Persistible {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer ciudad;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "evento_id")
    private List<Atuendo> posiblesAtuendos = new ArrayList<>();

    @ManyToOne(targetEntity = Atuendo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "atuendo_id")
    private Atuendo atuendoElegido;

    @Transient
    private NotificadorEvento notificadorEvento = new NotificadorAplicacion();

    @Column
    private Double temperatura;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Evento() {
    }

    public Evento(Integer ciudad) {
        this.ciudad = ciudad;
    }

    public Evento(Integer ciudad, NotificadorEvento notificadorEvento) {
        this.ciudad = ciudad;
        this.notificadorEvento = notificadorEvento;
    }

    public void notificar() {
        notificadorEvento.notificar(this);
    }

    /*
        getters
     */
    public Integer getId() {
        return id;
    }

    public List<Atuendo> getPosiblesAtuendos() {
        return posiblesAtuendos;
    }

    public Atuendo getAtuendoElegido() {
        return atuendoElegido;
    }

    public NotificadorEvento getNotificadorEvento() {
        return notificadorEvento;
    }

    public Integer getCiudad() {
        return ciudad;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*
    setters
     */
    public void setPosiblesAtuendos(List<Atuendo> posiblesAtuendos) {
        this.posiblesAtuendos = posiblesAtuendos;
    }

    public void setNotificadorEvento(NotificadorEvento notificadorEvento) {
        this.notificadorEvento = notificadorEvento;
    }

    //Este set es el "aceptarAtuendo" del usuario
    public void setAtuendoElegido(Atuendo atuendoElegido) {
        this.atuendoElegido = atuendoElegido;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public void setCiudad(Integer ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Evento [id=" + id + ", ciudad=" + ciudad + ", posiblesAtuendos=" + posiblesAtuendos
                + ", atuendoElegido=" + atuendoElegido + ", notificadorEvento=" + notificadorEvento + ", temperatura="
                + temperatura + "]";
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
