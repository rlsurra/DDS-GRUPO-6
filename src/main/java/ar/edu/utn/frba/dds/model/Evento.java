package ar.edu.utn.frba.dds.model;

import java.time.LocalDateTime;

public class Evento {
    private String ciudad;
    private LocalDateTime fecha;

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

    /*
    setters
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
