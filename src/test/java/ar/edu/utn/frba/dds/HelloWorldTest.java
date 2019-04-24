
package ar.edu.utn.frba.dds;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void deberiaSaludarCorrectamente() {
        Assert.assertEquals(new HelloWorld().saludar(), "¡Hola Mundo!");
    }

}