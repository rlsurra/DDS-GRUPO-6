package ar.edu.utn.frba.dds.model;

import javax.swing.text.html.HTMLDocument;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Evento {
    private String ciudad;
    private LocalDateTime fecha;
    private List<Atuendo> posiblesAtuendos = new ArrayList<>();
    private Atuendo atuendoElegido;

    public Evento(String ciudad, LocalDateTime fecha) {
        this.ciudad = ciudad;
        this.fecha = fecha;
    }

    /*
    getters
     */
    public String getCiudad() {
        return ciudad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public List<Atuendo> getPosiblesAtuendos() { return posiblesAtuendos;  }

    public Atuendo getAtuendoElegido() {  return atuendoElegido; }

    /*
    setters
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setPosiblesAtuendos(List<Atuendo> posiblesAtuendos) { this.posiblesAtuendos = posiblesAtuendos;}

    //Este set es el "aceptarAtuendo" del usuario
    public void setAtuendoElegido(Atuendo atuendoElegido) {this.atuendoElegido = atuendoElegido;}
}
