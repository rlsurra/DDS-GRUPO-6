package ar.edu.utn.frba.dds.model.usuario.tipoUsuario;

import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class TipoUsuarioPremium extends TipoUsuario {

    @Override
    public boolean validarCantidadMaxima(Guardarropa guardarropa) {
        return true;
    }
}
