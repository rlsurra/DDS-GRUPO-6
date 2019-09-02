package ar.edu.utn.frba.dds.model.usuario;

import ar.edu.utn.frba.dds.model.Guardarropa;

public class TipoUsuarioGratuito extends TipoUsuario{
    private static final int MAXIMA_CANTIDAD_PRENDAS = 5;

    @Override
    public boolean validarCantidadMaxima(Guardarropa guardarropa){
        int cantidadDePrendas = guardarropa.getPrendasSuperiores().size() +
                guardarropa.getPrendasInferiores().size() +
                guardarropa.getPrendasCalzado().size() +
                guardarropa.getPrendasAccesorio().size()-1 +
                guardarropa.getPrendasAbrigoLigero().size()-1 +
                guardarropa.getPrendasAbrigoPesado().size()-1;
        return cantidadDePrendas <= MAXIMA_CANTIDAD_PRENDAS;
    }
}
