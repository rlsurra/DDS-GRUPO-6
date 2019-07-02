package ar.edu.utn.frba.dds.model.usuario;

import ar.edu.utn.frba.dds.model.Guardarropa;

public class TipoUsuarioPremium extends TipoUsuario {
    @Override
    public boolean validarCantidadMaxima(Guardarropa guardarropa){
        return true;
    }
}
