package ar.edu.utn.frba.dds.model.usuario;

import ar.edu.utn.frba.dds.Persistible;
import ar.edu.utn.frba.dds.model.Guardarropa;

public class GuardarropaUsuario extends Persistible {

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
