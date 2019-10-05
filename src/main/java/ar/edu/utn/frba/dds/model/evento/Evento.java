package ar.edu.utn.frba.dds.model.evento;

import ar.edu.utn.frba.dds.model.Atuendo;
import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorAplicacion;
import ar.edu.utn.frba.dds.model.evento.notificador.NotificadorEvento;


import java.util.ArrayList;
import java.util.List;

public class Evento {
    private Integer ciudad;
    private List<Atuendo> posiblesAtuendos = new ArrayList<>();
    private Atuendo atuendoElegido;
    private NotificadorEvento notificadorEvento = new NotificadorAplicacion();
    private Double temperatura;

    public Evento(Integer ciudad) {
        this.ciudad = ciudad;
    }

    public Evento(Integer ciudad, NotificadorEvento notificadorEvento) {
        this.ciudad = ciudad;
        this.notificadorEvento = notificadorEvento;
    }

    public void notificar(){
	    notificadorEvento.notificar(this);
	}

	/*
        getters
    */
    public List<Atuendo> getPosiblesAtuendos() { return posiblesAtuendos;  }
    public Atuendo getAtuendoElegido() {  return atuendoElegido; }
    public NotificadorEvento getNotificadorEvento() { return notificadorEvento; }
    public Integer getCiudad() { return ciudad; }
	public Double getTemperatura() { return temperatura; }

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

}
