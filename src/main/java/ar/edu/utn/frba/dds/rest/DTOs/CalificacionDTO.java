package ar.edu.utn.frba.dds.rest.DTOs;

import ar.edu.utn.frba.dds.model.atuendo.Atuendo;

public class CalificacionDTO {

    private Long atuendoID;

    private Long calificacion;

    public Long getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }

    public Long getAtuendoID() {
        return atuendoID;
    }

    public void setAtuendoID(Long atuendoID) {
        this.atuendoID = atuendoID;
    }
}
