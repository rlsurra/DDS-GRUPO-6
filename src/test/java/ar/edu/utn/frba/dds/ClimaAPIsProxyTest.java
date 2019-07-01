package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.ClimaAPIsProxy;
import org.junit.Assert;
import org.junit.Test;

public class ClimaAPIsProxyTest {

    @Test
    public void testRequestTemperatura(){
        float temp;
        ClimaAPIsProxy proxy = new ClimaAPIsProxy();
        temp = proxy.getTemperatura(3435910);
        Assert.assertNotNull(temp);
        System.out.println(temp);
    }
}
