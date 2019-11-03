package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.clima.openWeatherAPI.OpenWeatherAdapter;
import org.junit.Assert;
import org.junit.Test;

public class OpenweatherTest {


    @Test
    public void testRequestTemperatura() {
        OpenWeatherAdapter temperatura = OpenWeatherAdapter.getTemperaturaByCiudadID(3435910); //Codigo de BsAs
        Assert.assertNotNull(temperatura.toString());
        System.out.println(temperatura.toString());
    }


}
