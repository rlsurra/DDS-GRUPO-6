package ar.edu.utn.frba.dds.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private Integer ciudad;
    private LocalDateTime fecha;
    private List<Atuendo> posiblesAtuendos = new ArrayList<>();
    private Atuendo atuendoElegido;

    public Evento(Integer ciudad, LocalDateTime fecha) {
        this.ciudad = ciudad;
        this.fecha = fecha;
    }

    /*
    getters
     */
    public Integer getCiudad() {
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
    public void setCiudad(Integer ciudad) {
        this.ciudad = ciudad;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setPosiblesAtuendos(List<Atuendo> posiblesAtuendos) { this.posiblesAtuendos = posiblesAtuendos;}

    //Este set es el "aceptarAtuendo" del usuario
    public void setAtuendoElegido(Atuendo atuendoElegido) {this.atuendoElegido = atuendoElegido;}
}
