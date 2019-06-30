package ar.edu.utn.frba.dds.model.usuario;

import ar.edu.utn.frba.dds.model.Guardarropa;

public abstract class TipoUsuario {
    public abstract boolean validarCantidadMaxima(Guardarropa guardarropa);
}
