package ar.edu.utn.frba.dds.model.openWeatherAPI;

import ar.edu.utn.frba.dds.model.ClimaAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.checkerframework.checker.units.qual.C;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table
public class OpenWeatherAdapter implements ClimaAdapter {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long identi;

    //No cambiar nombres de las variables porque rompe el parseo, ni siquiera con un refactor -> rename
    @Column
    private int cod;
@Column
    private int id;


@OneToOne(cascade = CascadeType.ALL)
    private TemperaturaOW main;
@Column
    private String name;



    @Override
    public float getTemperatura(int idCiudad){
        OpenWeatherAdapter temperatura = this.getTemperaturaByCiudadID(idCiudad);
        //El codigo 200 nos indica un response exitoso
        //Cuando temp=100.0f significa que hubo un error, esto lo usamos para iterar al proximo
        if(temperatura.cod != 200) {temperatura.main.setTemp(100.0f);}
        //Ver cacheo de errores

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


    public int getCod() {
        return cod;
    }

    public void setCod(int codResponse) {
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