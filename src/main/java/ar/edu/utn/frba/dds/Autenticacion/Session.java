package ar.edu.utn.frba.dds.Autenticacion;

import ar.edu.utn.frba.dds.model.usuario.Usuario;

public class Session {

    private String token;
    private Usuario usuario;

    public Session(String token, Usuario usuario){
        this.token = token;
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
