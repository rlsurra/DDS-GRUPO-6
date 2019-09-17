package ar.edu.utn.frba.dds.model.usuario;

import ar.edu.utn.frba.dds.exceptions.MaximaCantidadPrendasException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.model.Atuendo;
import ar.edu.utn.frba.dds.model.Evento;
import ar.edu.utn.frba.dds.model.Guardarropa;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private List<Guardarropa> guardarropas = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();
    private TipoUsuario tipoUsuario;

    public Usuario(TipoUsuario tipoUsuario){
        if (tipoUsuario == null) {
            throw new ParametrosInvalidosException("No se permite un usuario sin tipo");
        }
        this.tipoUsuario = tipoUsuario;
    }

    /*
    getters
     */
    public List<Guardarropa> getGuardarropas() {
        return guardarropas;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /*
    setters
     */
    public void agregarGuardarropa(Guardarropa guardarropa){
        if (guardarropa == null) {
            throw new ParametrosInvalidosException("No se permite agregar guardarropa nulo");
        }
        if(!tipoUsuario.validarCantidadMaxima(guardarropa)){
            throw new MaximaCantidadPrendasException();
        }
        guardarropas.add(guardarropa);
    }

    public void agregarEvento(Evento evento){
        if (evento == null) {
            throw new ParametrosInvalidosException("No se permite agregar un evento nulo");
        }
        if (this.eventos == null) {
            this.eventos = new ArrayList<>();
        }
        this.eventos.add(evento);
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "guardarropas=" + guardarropas +
                ", eventos=" + eventos +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
