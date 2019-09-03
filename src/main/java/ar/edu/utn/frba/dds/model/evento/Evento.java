package ar.edu.utn.frba.dds.model.evento;

import ar.edu.utn.frba.dds.model.Atuendo;
import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorAplicacion;
import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorEvento;

import javax.swing.text.html.HTMLDocument;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Evento {
    private String ciudad;
    private List<Atuendo> posiblesAtuendos = new ArrayList<>();
    private Atuendo atuendoElegido;
    private NotificadorEvento notificadorEvento = new NotificadorAplicacion();

    public Evento(String ciudad) {
        this.ciudad = ciudad;
    }

    public Evento(String ciudad, NotificadorEvento notificadorEvento) {
        this.ciudad = ciudad;
        this.notificadorEvento = notificadorEvento;
    }

    /*
        getters
         */
    public String getCiudad() {
        return ciudad;
    }

    public List<Atuendo> getPosiblesAtuendos() { return posiblesAtuendos;  }
    public Atuendo getAtuendoElegido() {  return atuendoElegido; }
    public NotificadorEvento getNotificadorEvento() {
        return notificadorEvento;
    }

    /*
    setters
     */

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setPosiblesAtuendos(List<Atuendo> posiblesAtuendos) { this.posiblesAtuendos = posiblesAtuendos;}
    public void setNotificadorEvento(NotificadorEvento notificadorEvento) {
        this.notificadorEvento = notificadorEvento;
    }

    //Este set es el "aceptarAtuendo" del usuario
    public void setAtuendoElegido(Atuendo atuendoElegido) {this.atuendoElegido = atuendoElegido;}

    public void notificar(){
        notificadorEvento.notificar(this);
    }

}
