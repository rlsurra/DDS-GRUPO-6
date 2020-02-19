package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.csvReader.CSVReader;
import ar.edu.utn.frba.dds.csvReader.Ciudad;
import ar.edu.utn.frba.dds.model.CiudadesService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CiudadesServiceTest {

    private CiudadesService service;

    @Before
    public void setUp() {
        service = CiudadesService.CiudadesService();
        List<Ciudad> ciudades = CSVReader.readBooksFromCSV("/Users/juanmartinconde/Documents/Facultad/DDS/2019/QMP/DDS-GRUPO-6/src/main/resources/ciudades.csv");
        service.setCiudades(ciudades);
    }

    @Test
    public void buscarCiudad() {
        try {
            Ciudad ciudad = service.buscarCiudad("Vicente López");
            System.out.println(ciudad.getName());
        } catch (Exception e) {
            System.out.println("Se pincho el test");
        }
    }


}
