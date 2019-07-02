package ar.edu.utn.frba.dds.model.openWeatherAPI;

import ar.edu.utn.frba.dds.model.ClimaAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.client.RestTemplate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherAdapter implements ClimaAdapter {

    //No cambiar nombres de las variables porque rompe el parseo, ni siquiera con un refactor -> rename
    private int cod;
    private int id;
    private TemperaturaOW main;
    private String name;

    @Override
    public float getTemperatura(int idCiudad){
        OpenWeatherAdapter temperatura = this.getTemperaturaByCiudadID(idCiudad);
        //El codigo 0 nos dice que la respuesta fue exitosa
        //Cuando temp=100.0f significa que hubo un error, esto lo usamos para iterar al proximo
        if(temperatura.cod != 0) {temperatura.main.setTemp(100.0f);}

        return temperatura.main.getTemp();
    }

    public static OpenWeatherAdapter getTemperaturaByCiudadID(int idCiudad) {
        String uri="https://api.openweathermap.org/data/2.5/weather?id="+idCiudad+"&appid=9de01d0c8f622c95601a4b3aee0f5040&units=metric";
        RestTemplate restTemplate= new RestTemplate();
        return restTemplate.getForObject(uri, OpenWeatherAdapter.class);
    }

    public String toString() {
        return "TemperaturaOW = " + main.getTemp() + "\n" +
                "Codigo de estado = " + cod + "\n" +
                "Ciudad = " + name +"\n" +
                "idCiudad = " + id;
    }

    public TemperaturaOW getMain() {
        return main;
    }

    public void setMain(TemperaturaOW main) {
        this.main = main;
    }

    public int getCodResponse() {
        return cod;
    }

    public void setCodResponse(int codResponse) {
        this.cod = codResponse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}