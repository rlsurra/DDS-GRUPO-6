package ar.edu.utn.frba.dds.model.prenda;

import ar.edu.utn.frba.dds.model.material.Material;
import ar.edu.utn.frba.dds.model.prenda.tipoPrenda.TipoPrenda;
import ar.edu.utn.frba.dds.persistence.Entidad;

import java.util.stream.Collectors;

public class ValidacionPrendaMaterial {

    public static boolean validarPrenda(Material material, TipoPrenda tipoPrenda) {
        return tipoPrenda.getMaterialesPermitidos().stream().map(Entidad::getNombre).collect(Collectors.toList()).contains(material.getNombre());
    }

}
