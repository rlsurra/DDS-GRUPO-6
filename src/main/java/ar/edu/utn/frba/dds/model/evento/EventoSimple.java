package ar.edu.utn.frba.dds.model.evento;

import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.rest.DTOs.EventoDTO;
import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity(name = "eventosimple")
@Table
public class EventoSimple extends Evento {

    @Column
    private LocalDateTime fecha;

    public EventoSimple() {
    }

    public EventoSimple(Integer ciudad, LocalDateTime fecha) {
        super(ciudad);
        this.fecha = fecha;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public Evento fillWithDTO(EventoDTO eventoDTO, Evento evento){
        evento = super.fillWithDTO(eventoDTO, evento);
        EventoSimple eventoSimple = (EventoSimple) evento;
        if (eventoDTO.getFecha() == null){
            throw new ParametrosInvalidosException("Los eventos simples deben tener una fecha de ejecucion");
        }
        if (eventoDTO.getHora() == null){
            throw new ParametrosInvalidosException("Los eventos simples deben tener una hora de ejecucion");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(eventoDTO.getFecha() + " " + eventoDTO.getHora(), formatter);
        eventoSimple.setFecha(dateTime);
        return eventoSimple;
    }

    public void initOnDemand() {
        if (this.getFecha().isBefore(LocalDateTime.now().plusDays(4))){
            this.init();
        }
    }
}
