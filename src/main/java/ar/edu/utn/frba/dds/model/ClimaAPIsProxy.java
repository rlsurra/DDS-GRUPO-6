package ar.edu.utn.frba.dds.model;

import ar.edu.utn.frba.dds.exceptions.NoSePudoConectarConNingunaApiDeClima;
import ar.edu.utn.frba.dds.model.openWeatherAPI.OpenWeatherAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimaAPIsProxy {
    private List<ClimaAdapter> apis = new ArrayList<>(Arrays.asList(new OpenWeatherAdapter()));

    public float getTemperatura(int idCiudad){
        int iterador = apis.size(); //Asumo la lista no está vacía, dsp ver validaciones //TODO
        float temp = 99999; //La inicializo en condicion de error

        while(iterador > 0 && temp != 99999) {
            temp = apis.get(iterador-1).getTemperatura(idCiudad);
            iterador --;
        };

    //Acá manejo errores de conexion con las APIs
    if(temp != 99999){return temp; }
    else {throw new NoSePudoConectarConNingunaApiDeClima("Fallo en la conexion con las APIs de clima");}

    }

}
