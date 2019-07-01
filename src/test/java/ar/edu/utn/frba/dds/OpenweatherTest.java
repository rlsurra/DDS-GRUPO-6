package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.openweather.TempyEstado;
import org.junit.Assert;
import org.junit.Test;

public class OpenweatherTest {

   @Test
    public void testRequestTemperatura(){
       TempyEstado temperatura = TempyEstado.tempPorIdCiudad(3435910);
       Assert.assertNotNull(temperatura.toString());
       System.out.println(temperatura.toString());
   }
}
