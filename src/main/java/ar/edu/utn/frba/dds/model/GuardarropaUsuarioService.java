package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.exceptions.GuardarropaUsuarioException;
import ar.edu.utn.frba.dds.model.usuario.GuardarropaUsuario;
import ar.edu.utn.frba.dds.model.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuardarropaUsuarioService {

//    --------------------------------------------------------------------------------------------------
//      ESTO ES PARA QUE SEA UNA CLASE SINGLETON, SOLO SE CREA UNA VEZ
    private static GuardarropaUsuarioService INSTANCE = null;

    private GuardarropaUsuarioService() {
        //TODO: Cargar los datos de la BBDD o donde esten y se guarden las relaciones
    }

    public static GuardarropaUsuarioService GuardarropaUsuarioService(){
        if(INSTANCE == null){
            INSTANCE = new GuardarropaUsuarioService();
        }
        return INSTANCE;
    }

//    --------------------------------------------------------------------------------------------------


    private List<GuardarropaUsuario> guardarropasCompartidos = new ArrayList<>();

    public void agregarRelacion(Usuario usuario, Guardarropa guardarropa){
        if (guardarropa.getPropietario() == usuario) {
            throw new GuardarropaUsuarioException("El usuario es propietario del guardarropa indicado! Solo se puede agregar relaciones de compartimiento.");
        }
        GuardarropaUsuario nuevaRelacion = new GuardarropaUsuario(guardarropa, usuario);
        guardarropasCompartidos.add(nuevaRelacion);
    }

    public List<GuardarropaUsuario> obtenerUsuariosCompartidosDeGuardarropa(Guardarropa guardarropa){
        return guardarropasCompartidos.stream()
                .filter(guardarropaUsuario -> guardarropaUsuario.getGuardarropa() == guardarropa)
                .collect(Collectors.toList());
    }

    public List<GuardarropaUsuario> obtenerGuardarropasCompartidosPorElUsuario(Usuario usuario){
        return guardarropasCompartidos.stream()
                .filter(guardarropaUsuario -> guardarropaUsuario.getUsuario() == usuario)
                .collect(Collectors.toList());
    }

}
