package ar.edu.utn.frba.dds.model.guardarropaUsuario;

import ar.edu.utn.frba.dds.persistence.Entidad;
import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import ar.edu.utn.frba.dds.model.usuario.Usuario;

public class GuardarropaUsuario extends Entidad {

    public Guardarropa guardarropa;
    public Usuario usuario;

    public GuardarropaUsuario(Guardarropa guardarropa, Usuario usuario) {
        this.guardarropa = guardarropa;
        this.usuario = usuario;
    }

    public Guardarropa getGuardarropa() {
        return guardarropa;
    }

    public void setGuardarropa(Guardarropa guardarropa) {
        this.guardarropa = guardarropa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
