package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.exceptions.NoSePudoConectarConNingunaApiDeClima;
import ar.edu.utn.frba.dds.model.openWeatherAPI.OpenWeatherAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ClimaAPIsProxy {
    private List<ClimaAdapter> apis = new ArrayList<>(Arrays.asList(new OpenWeatherAdapter()));

    public float getTemperatura(int idCiudad){
        Iterator<ClimaAdapter> apisIterator = apis.iterator();
        float temp = 100.0f; //La inicializo en condicion de error

        while(apisIterator.hasNext()) {
            ClimaAdapter ca = apisIterator.next();
            temp = ca.getTemperatura(idCiudad);
            if(temp != 100.0f) {break;}
        };

    //Acá manejo errores de conexion con las APIs
    if(temp != 100.0f){return temp; }
    else {throw new NoSePudoConectarConNingunaApiDeClima("Fallo en la conexion con las APIs de clima");}
    }

}
