package ar.edu.utn.frba.dds.model.usuario;

import ar.edu.utn.frba.dds.model.Guardarropa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("G")
public class TipoUsuarioGratuito extends TipoUsuario{

    @Transient
    private static final int MAXIMA_CANTIDAD_PRENDAS = 5;

    @Override
    public boolean validarCantidadMaxima(Guardarropa guardarropa){
        int cantidadDePrendas = guardarropa.getPrendas().size();
        return cantidadDePrendas <= MAXIMA_CANTIDAD_PRENDAS;
    }
}
