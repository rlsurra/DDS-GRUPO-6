package ar.edu.utn.frba.dds.Autenticacion;

import ar.edu.utn.frba.dds.model.usuario.Usuario;

public class Session {

    private String token;
    private Long usuarioId;

    public Session(String token, Long usuarioid){
        this.token = token;
        this.usuarioId = usuarioid;
    }

    public String getToken() {
        return token;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }
}
