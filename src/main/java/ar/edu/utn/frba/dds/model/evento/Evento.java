package ar.edu.utn.frba.dds.model.evento;

import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.persistence.Entidad;
import ar.edu.utn.frba.dds.model.atuendo.Atuendo;
import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorAplicacion;
import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorEvento;
import ar.edu.utn.frba.dds.model.usuario.Usuario;
import ar.edu.utn.frba.dds.persistence.Repositorio;
import ar.edu.utn.frba.dds.rest.DTOs.EventoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "evento")
public class Evento extends Entidad {

    @Column
    private Integer ciudad;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "evento_id")
    private List<Atuendo> posiblesAtuendos = new ArrayList<>();

    @ManyToOne(targetEntity = Atuendo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "atuendo_id")
    private Atuendo atuendoElegido;

    @OneToOne(cascade = CascadeType.ALL)
    private NotificadorEvento notificadorEvento = new NotificadorAplicacion();

    @Column
    private Double temperatura;

    @ManyToOne
    @JsonIgnoreProperties({"guardarropas", "eventos", "tipoUsuario", "guardarropasAccedidos", "refTemperatura", "puntajes", "historialAtuendos"})
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

    @JsonIgnoreProperties({"guardarropas", "eventos", "tipoUsuario", "guardarropasAccedidos", "refTemperatura", "puntajes", "historialAtuendos"})
    public Usuario getUsuario() {
        return usuario;
    }

    @JsonIgnoreProperties({"guardarropas", "eventos", "tipoUsuario", "guardarropasAccedidos", "refTemperatura", "puntajes", "historialAtuendos"})
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento fillWithDTO(EventoDTO eventoDTO, Evento evento) {
        if(eventoDTO.getNombre() == null){
            throw new ParametrosInvalidosException("El evento debe tener nombre");
        }
        evento.setNombre(eventoDTO.getNombre());
        if(eventoDTO.getCiudad() == null){
            throw new ParametrosInvalidosException("El evento debe tener una Ciudad");
        }
        evento.setCiudad(eventoDTO.getCiudad());
        return evento;
    }

    public void initOnDemand() {
        //DO NOTHING
    }

    protected void init() {
        List<Atuendo> atuendosPosibles = new ArrayList<>();
        for (Guardarropa guardarropa : this.getUsuario().getGuardarropas() ){
            atuendosPosibles.addAll(guardarropa.generarSugerencias(this.getUsuario(), this));
        }
        this.setPosiblesAtuendos(atuendosPosibles);
        Repositorio.getInstance().update(this);
    }
}
