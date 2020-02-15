package ar.edu.utn.frba.dds.rest.DTOs;

public class PuntajeDTO {

    private Integer prendaid;

    private Integer puntaje;

    public PuntajeDTO() {
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getPrendaid() {
        return prendaid;
    }

    public void setPrendaid(Integer prendaid) {
        this.prendaid = prendaid;
    }
}
