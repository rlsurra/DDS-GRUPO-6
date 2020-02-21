package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.csvReader.Ciudad;
import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CiudadesService {

    private static CiudadesService INSTANCE = null;

    private CiudadesService() {
        this.ciudades = new ArrayList<>();
    }

    public static CiudadesService CiudadesService() {
        if (INSTANCE == null) {
            INSTANCE = new CiudadesService();
        }
        return INSTANCE;
    }


    public List<Ciudad> ciudades;

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public Ciudad buscarCiudad(String ciudad) throws EntidadNoEncontradaException {

        List<Ciudad> collect = this.ciudades.stream().filter(ciudad1 -> ciudad1.getName().equals(ciudad)).collect(Collectors.toList());

        if (collect.size() == 1) {
            return collect.get(0);
        }

        throw new EntidadNoEncontradaException("No se puede encontrar la ciudad buscada");
    }
}
