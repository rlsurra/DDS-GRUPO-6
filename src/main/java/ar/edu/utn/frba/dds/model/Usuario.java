package ar.edu.utn.frba.dds.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private List<Guardarropa> guardarropas = new ArrayList<>();

    public void agregarGuardarropa(Guardarropa guardarropa){
        guardarropas.add(guardarropa);
    }

    public Map<Guardarropa, List<Atuendo>> queMePongo(){
        Map<Guardarropa, List<Atuendo>> sugerencias = new HashMap<>();
        for (Guardarropa guardarropa : guardarropas) {
            List<Atuendo> atuendos = guardarropa.getAtuendos();
            sugerencias.put(guardarropa, atuendos);
        }
        return sugerencias;
    }
}
