package ar.edu.utn.frba.dds.openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.web.client.RestTemplate;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TempyEstado {
    private Temperatura main;
    private int         cod;
    private int         id;
    private String      name;


    public static  TempyEstado tempPorIdCiudad(int idCiudad){
        String uri="https://api.openweathermap.org/data/2.5/weather?id="+idCiudad+"&appid=9de01d0c8f622c95601a4b3aee0f5040&units=metric";
        RestTemplate restTemplate= new RestTemplate();
        return restTemplate.getForObject(uri,TempyEstado.class);
    }




    @Override
    public String toString() {
        return
                        "Temperatura="      + main.getTemp() + "\n" +
                        "Codigo de estado=" + cod + "\n"+
                        "Ciudad="           + name  +"\n"+
                        "idCiudad="         + id
                ;
    }



    public Temperatura getMain() {
        return main;
    }

    public void setMain(Temperatura main) {
        this.main = main;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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