package ar.edu.utn.frba.dds.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private List<Guardarropa> guardarropas = new ArrayList<>();

    public void getAtuendo(Guardarropa guardarropa){
        guardarropa.getAtuendo();
    }
}
