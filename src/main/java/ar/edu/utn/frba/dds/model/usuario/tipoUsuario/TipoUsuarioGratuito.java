package ar.edu.utn.frba.dds.model.usuario.tipoUsuario;

import ar.edu.utn.frba.dds.model.guardarropa.Guardarropa;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("G")
public class TipoUsuarioGratuito extends TipoUsuario {

    @Transient
    @JsonIgnore
    private static final int MAXIMA_CANTIDAD_PRENDAS = 5;

    @Override
    public boolean validarCantidadMaxima(Guardarropa guardarropa) {
        int cantidadDePrendas = guardarropa.getPrendas().size();
        return cantidadDePrendas <= MAXIMA_CANTIDAD_PRENDAS;
    }
}
