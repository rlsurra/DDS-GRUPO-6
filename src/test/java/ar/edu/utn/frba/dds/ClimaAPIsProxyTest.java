package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.model.clima.ClimaAPIsProxy;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClimaAPIsProxyTest {

    @Test
    public void testRequestTemperatura() {
        float temp;
        ClimaAPIsProxy proxy = new ClimaAPIsProxy();
        temp = proxy.getTemperatura(3435910);
        Assert.assertNotNull(temp);
        System.out.println(temp);
    }

    @Test
    public void testMockRequestTemperatura() {
        float temp;
        ClimaAPIsProxy mockProxy = mock(ClimaAPIsProxy.class);
        when(mockProxy.getTemperatura(3435910)).thenReturn(150.0f);

        temp = mockProxy.getTemperatura(3435910);
        Assert.assertEquals(150.0f, temp, 0);
        System.out.println(temp);
    }
}
