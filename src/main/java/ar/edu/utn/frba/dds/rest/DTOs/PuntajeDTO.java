package ar.edu.utn.frba.dds.rest.DTOs;

public class PuntajeDTO {

    private Long prendaid;

    private Double puntaje;

    public PuntajeDTO() {
    }


    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    public Long getPrendaid() {
        return prendaid;
    }

    public void setPrendaid(Long prendaid) {
        this.prendaid = prendaid;
    }
}
